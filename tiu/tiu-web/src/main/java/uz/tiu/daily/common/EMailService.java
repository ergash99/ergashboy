package uz.tiu.daily.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import uz.tiu.daily.common.configuration.EMailConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class EMailService implements Serializable {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private JavaMailSender mailSender;

    private EMailConfiguration eMailConfiguration;

    private long sequenceChannel;

    private boolean enabled;

    // thread safe synchronization objects
    private final Object syncMailSender = new Object();
    private final Object syncMessageQueueMap = new Object();

    private volatile Map<Long, List<MimeMessage>> messageQueueMap;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void seteMailConfiguration(EMailConfiguration eMailConfiguration) {
        this.eMailConfiguration = eMailConfiguration;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @PostConstruct
    public void init()
    {
        enabled = eMailConfiguration.isEnabled();

        if (!enabled) {
            if (logger.isInfoEnabled())
                logger.info("EMAIL: Service disabled by configuration.");
            return;
        }

        messageQueueMap = new HashMap<Long, List<MimeMessage>>();
        sequenceChannel = 0;

        if (logger.isInfoEnabled())
            logger.info("EMAIL: Service is ready");

    }

    public synchronized long getNextChannelSequence()
    {
        return ++sequenceChannel;
    }

    public void addMailToQueue(long channel, String to, String subject, String text, FileSystemResource[] files)
    {

        addMailToQueue(channel, eMailConfiguration.getDefaultSender(), to, subject, text, files);

    }

    public void addMailToQueue(long channel, String from, String to, String subject, String text, FileSystemResource[] files) {

        List<MimeMessage> mimeMessages;
        synchronized (syncMessageQueueMap)
        {
            mimeMessages = messageQueueMap.get(channel);
        }

        MimeMessage message = mailSender.createMimeMessage();
        try{

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            // helper.setSubject(subject);

            StringBuilder htmlText = new StringBuilder();
            htmlText.append("<html>");
            htmlText.append("<body>");
            htmlText.append(text);
            // htmlText.append("<img src=\"cid:greetingImage\"/>");
            htmlText.append("</body>");
            htmlText.append("</html>");

            // helper.setText(htmlText.toString(), true);

            message.setSubject(subject, "UTF-8");
            message.setHeader("Content-Type","text/html; charset=UTF-8");
            message.setHeader("Content-Transfer-Encoding","base64");
            message.setContent(htmlText.toString(), "text/html; charset=UTF-8");

            // Inline content
            // FileSystemResource inlineContent = new FileSystemResource("/greetingImage.jpg");
            // helper.addInline("greetingImage", inlineContent);

            if (files!=null)
            {
                for (FileSystemResource file : files)
                {
                    //FileSystemResource file = new FileSystemResource("C:\\log.txt");
                    helper.addAttachment(file.getFilename(), file);
                }
            }

        }catch (MessagingException e) {
            logger.warn("MessagingException", e);
        }

        if (mimeMessages==null)
            mimeMessages = new ArrayList<MimeMessage>();

        mimeMessages.add(message);

        synchronized (syncMessageQueueMap)
        {
            messageQueueMap.put(channel, mimeMessages);
        }

        if (logger.isTraceEnabled())
            logger.trace("Mail queued to {} as #", to, mimeMessages.size());
    }

    public void sendQueuedMail(long channel, boolean removeSent) {

        List<MimeMessage> mimeMessageList;
        synchronized (syncMessageQueueMap)
        {
            mimeMessageList = messageQueueMap.get(channel);
        }

        if (mimeMessageList!=null && !mimeMessageList.isEmpty())
        {
            MimeMessage[] messages = new MimeMessage[mimeMessageList.size()];
            mimeMessageList.toArray(messages);

            synchronized (syncMailSender)
            {
                if (logger.isTraceEnabled())
                    logger.trace("Start of batch sending emails on channel #{} ...", channel);

                mailSender.send(messages);

                if (logger.isTraceEnabled())
                    logger.trace("Mail channel {}, sent mails count: {}", channel, messages.length);
            }
            if (removeSent)
            {
                synchronized (syncMessageQueueMap)
                {
                    messageQueueMap.remove(channel);
                }
            }
        }
    }

    public void sendQueuedMailinThread(final long channel, final boolean removeSent) {

        Runnable myRunnable = new Runnable(){
           public void run(){
               sendQueuedMail(channel, removeSent);
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

    public void sendMail(String[] to, String subject, String text, FileSystemResource[] files)
    {
        sendMail(eMailConfiguration.getDefaultSender(), to, subject, text, files);
    }

    public void sendMail(final String from, final String[] to, final String subject, final String text, final FileSystemResource[] files)
    {
        Runnable myRunnable = new Runnable(){
            public void run(){
                long channel = getNextChannelSequence();
                for (String rcpt_to : to)
                {
                    if (rcpt_to!=null)
                    {
                        rcpt_to = rcpt_to.trim();
                        if (rcpt_to.length()>5)
                            addMailToQueue(channel, from, rcpt_to, subject, text, files);
                    }
                }
                sendQueuedMail(channel, true);
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    @PreDestroy
    public void destroy() {
        if (!enabled)
            return;

        try {
            if (logger.isInfoEnabled())
                logger.info("EMAIL: Service shut down successfully");

        } catch (Exception e) {
            logger.error("EMAIL-Exception", e);
        }
    }
}


