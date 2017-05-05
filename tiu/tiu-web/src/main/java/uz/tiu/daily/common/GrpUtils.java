package uz.tiu.daily.common;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class GrpUtils
    {
        public static Logger logger = LoggerFactory.getLogger("elp.common.GrpUtils");

        public static String StringDecode(String input)
        {
            String strNew = null;
            try
            {
                if (input != null)
                {
    //                strNew = new String(input.getBytes("Cp1252"), "Cp1251");
                    strNew = new String(input.getBytes("ISO8859-1"), "UTF-8");
                }
            }
            catch (UnsupportedEncodingException e)
            {
                logger.error("Unsupported codepage catched.", e);
            }
            return strNew;
        }

        public static String GetPaswdHash(String strPswd)
        {
            byte[] md5 = new byte[32];
            try
            {
                MessageDigest md;
                md = MessageDigest.getInstance("MD5");
                md.update(strPswd.getBytes("iso-8859-1"), 0, strPswd.length());
                md5 = md.digest();
            }
            catch (NoSuchAlgorithmException e)
            {
                logger.error("MD5 is not supported",e);
            }
            catch (UnsupportedEncodingException e)
            {
                 logger.error("Encoding is not supported", e);
            }
            return ConvertToHex(md5);
        }

        public static String ConvertToHex(byte[] data)
        {
            StringBuffer buf = new StringBuffer();
            for (byte aData : data) {
                int halfbyte = (aData >>> 4) & 0x0F;
                int two_halfs = 0;
                do {
                    if ((0 <= halfbyte) && (halfbyte <= 9))
                        buf.append((char) ('0' + halfbyte));
                    else
                        buf.append((char) ('a' + (halfbyte - 10)));
                    halfbyte = aData & 0x0F;
                } while (two_halfs++ < 1);
            }
            return buf.toString().toUpperCase();
        }

        public static String ConvertToBase64(byte[] data)
        {
            Base64 base64 = new Base64();
            byte [] code = base64.encode(data);
            StringBuffer buf = new StringBuffer();
            for (byte aCode : code) {
                buf.append((char) aCode);
            }
            return buf.toString();
        }

        public static String convertToNormalUnicode(String source)
        {
            // function replaces &#xxxx; with char(xxxx)
            if (source==null)
                return null;

            StringBuilder rez = new StringBuilder();
            int len= source.length();
            char ch;
            for (int pos=0;pos<len;pos++)
            {
                ch = source.charAt(pos);
                if (ch=='&' && (pos+6)<len && source.charAt(pos+1)=='#' && source.charAt(pos+6)==';')
                {
                    try {
                        ch=(char) Integer.parseInt(source.substring(pos+2, pos+6));
                        pos+=6;
                    } catch (NumberFormatException e) {
                      //
                    }
                }
                rez.append(ch);
            }
            return rez.toString();
        }

        public static boolean removeFile(String filename)
        {
            if (filename!=null && !filename.isEmpty())
            {
                File file =  new File(filename);
                if (file.exists())
                    return file.delete();
            }
            return false;
        }
        
        public static void copyFile (File srcFile, File outFile) throws IOException {
            FileInputStream from = new FileInputStream(srcFile);
            FileOutputStream to = new FileOutputStream(outFile);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = from.read(buffer)) != -1)
                 to.write(buffer, 0, bytesRead);

            from.close();
            to.close();
        }

        public static void copyStream2File (InputStream from, File outFile) throws IOException {
            FileOutputStream to = new FileOutputStream(outFile);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = from.read(buffer)) != -1)
                to.write(buffer, 0, bytesRead);

            from.close();
            to.close();
        }

        public static byte[] getBytesFromFile(File file) throws IOException
        {
            InputStream is = new FileInputStream(file);

            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                throw new IOException("File is too large to process");
            }

            byte[] bytes = new byte[(int)length];

            int offset = 0;
            int numRead;
            while ( (offset < bytes.length) && ((numRead=is.read(bytes, offset, bytes.length-offset)) >= 0))
                    offset += numRead;

            if (offset < bytes.length)
                throw new IOException("Could not completely read file " + file.getName());

            is.close();
            return bytes;
        }

        public static String getFileExtension(String filename)
        {
            String ext = null;
            if (filename!=null && !filename.isEmpty())
            {
                int dot = filename.lastIndexOf('.');
                if (dot >0 && dot <= filename.length() - 2 )
                    ext = filename.substring(dot+1); // take without dot
            }
            return ext;
        }

        public static String extractName(String filename)
        {
            String name = null;
            if (filename!=null && !filename.isEmpty())
            {
                int dot = filename.lastIndexOf('.');
                if (dot > 0)
                    name = filename.substring(0, dot); // take without dot
            }
            return name;
        }

    }
