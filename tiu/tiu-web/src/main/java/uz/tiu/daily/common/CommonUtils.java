package uz.tiu.daily.common;



import org.springframework.web.servlet.ModelAndView;

import javax.xml.namespace.QName;
import javax.xml.stream.events.XMLEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;

public class CommonUtils {
    public static String getStackTrace(Throwable t)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    public enum GuideType {
        DB,
        DEPARTMENT,
        USER,
        ORG;
    }

    public enum MessageType {
        INFO,
        SUCCESS,
        ERROR
    }

    public class FileUploadBean {

        private byte[] file;

        public void setFile(byte[] file) {
            this.file = file;
        }

        public byte[] getFile() {
            return file;
        }
    }

    public static ModelAndView getMessageDialog(String messageText, String messageDetails, MessageType messageType) {
        ModelAndView modelAndView = new ModelAndView("common/ajaxMessage");
        modelAndView.addObject("messageText",messageText);
        modelAndView.addObject("messageDetails",messageDetails);
        return modelAndView;
    }

    public static ModelAndView getMessageDialog(String messageText) {
        return getMessageDialog(messageText, null, MessageType.INFO);
    }

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32).substring(0,15);
    }

    public static Timestamp safeParseTimestamp(String value) {
        try {
            if (value!=null&&value.length()>0) {
                if (value.length()==10) {
                    value = value.substring(6,10)+'-'+value.substring(3,5)+'-'+value.substring(0,2);
                    value = value.concat(" 00:00:00.000");
                }
                return Timestamp.valueOf(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Long safeParseLong(String value) {
        try {
            if (value!=null&&value.length()>0) {
                return Long.parseLong(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Long safeParseLong(Object value) {
        try {
            if (value!=null) {
                return (Long)value;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Short safeParseShort(String value) {
        try {
            if (value!=null&&value.length()>0) {
                return Short.parseShort(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer safeParseInteger(String value) {
        try {
            if (value!=null&&value.length()>0) {
                return Integer.parseInt(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean safeParseBoolean(String value) {
        try {
            if (value!=null&&value.length()>0) {
                return Boolean.parseBoolean(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private String getAttribute(XMLEvent event, String attributeName) {
        if (event.isStartElement()) {
            return event.asStartElement().getAttributeByName(new QName(attributeName)).getValue();
        } else {
            return null;
        }
    }

    private Boolean isStartElement(XMLEvent event, String elementName) {
        if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals(elementName)) {
            return true;
        } else {
            return false;
        }
    }

    public static Integer calcMaxPage(Integer rowCount, Integer limitRows) {
        Integer maxPages = (rowCount-rowCount%limitRows)/limitRows+(rowCount%limitRows>0?1:0);
        if (maxPages==0) maxPages = 1;
        return maxPages;
    }
}