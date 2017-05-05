package uz.tiu.daily.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.*;
import org.smslib.modem.SerialModemGateway;
import uz.tiu.daily.common.configuration.SmsConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;



public class SmsService implements Serializable {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private SmsConfiguration smsConfiguration;


    public void setSmsConfiguration(SmsConfiguration smsConfiguration) {
        this.smsConfiguration = smsConfiguration;
    }

    @PostConstruct
    public void init()
    {
        if (!smsConfiguration.isEnabled()) {
            if (logger.isInfoEnabled())
                logger.info("SMS: Service disabled by configuration.");
            return;
        }

        if (logger.isTraceEnabled())
            logger.trace("SMS: Preparing connection...");

        try {

            OutboundNotification outboundNotification = new OutboundNotification();
            if (logger.isDebugEnabled())
            {
                logger.debug(smsConfiguration.getConfigString());
                logger.debug(Library.getLibraryDescription());
                logger.debug("SMSlib Version: " + Library.getLibraryVersion());
            }
            SerialModemGateway gateway = new SerialModemGateway(smsConfiguration.getModemId(), smsConfiguration.getModemComPort(),
                                                smsConfiguration.getModemBaudRate(), smsConfiguration.getModemManufacturer(), smsConfiguration.getModemModel());
            gateway.setInbound(true);
            gateway.setOutbound(true);
            gateway.setSimPin(smsConfiguration.getModemSimPin());

            // Explicit SMSC address set is required for some modems.
            gateway.setSmscNumber(smsConfiguration.getSmsc());
            Service.getInstance().setOutboundMessageNotification(outboundNotification);
            Service.getInstance().addGateway(gateway);

            Service.getInstance().startService();

            if (logger.isInfoEnabled()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Modem Information:");
                stringBuilder.append("[ Manufacturer: ").append(gateway.getManufacturer());
                stringBuilder.append(", Model: ").append(gateway.getModel());
                stringBuilder.append(", Serial No: ").append(gateway.getSerialNo());
                stringBuilder.append(", SIM IMSI: ").append(gateway.getImsi());
                stringBuilder.append(", Signal Level: ").append(gateway.getSignalLevel()).append(" dBm");
                stringBuilder.append(", Battery Level: ").append(gateway.getBatteryLevel()).append("% ]");
                logger.info(stringBuilder.toString());
            }

            if (logger.isInfoEnabled())
                logger.info("SMS: Service is ready");

        } catch (Exception e) {
            logger.error("SMSException", e);
        }
    }

    @PreDestroy
    public void destroy() {
        if (!smsConfiguration.isEnabled())
            return;

        try {

            Service.getInstance().stopService();
            if (logger.isInfoEnabled())
                logger.info("SMS: Service shut down successfully");

        } catch (Exception e) {
            logger.error("SMSException", e);
        }
    }

    public void sendMessage(String messageRecipient, String messageText) {

        if (logger.isTraceEnabled())
            logger.trace("SMS: message={}, recipient ={}", messageText, messageRecipient);

        if (!smsConfiguration.isEnabled()) {
            if (logger.isTraceEnabled())
                logger.trace("SMS: Service disabled by configuration. Send ignored");
            return;
        }

        if (messageText == null || messageRecipient == null) {
            if (logger.isDebugEnabled())
                logger.debug("SMS: Parameters are not complete. Send aborted");
            return;
        }

        try {

            // Send a message synchronously.
            OutboundMessage msg = new OutboundMessage(messageRecipient, messageText);
            Service.getInstance().sendMessage(msg);

            if (logger.isDebugEnabled())
                logger.debug(msg.toString());

            if (logger.isDebugEnabled())
                logger.debug("SMS: Message sent. Message:{}", messageText);

        } catch (Exception e) {
            logger.error("SMSException", e);
        }
    }

    public class OutboundNotification implements IOutboundMessageNotification
    {
        public void process(AGateway gateway, OutboundMessage msg)
        {
            if(logger.isDebugEnabled())
            {
                logger.debug("Outbound handler called from Gateway: " + gateway.getGatewayId());
                logger.debug("message: {}", msg);
            }
        }
    }

}


