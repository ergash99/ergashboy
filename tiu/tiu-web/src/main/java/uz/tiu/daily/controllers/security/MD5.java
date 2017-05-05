package uz.tiu.daily.controllers.security;

import uz.tiu.daily.common.Constants;

import java.security.MessageDigest;

/**
 * Created by Zoxir on 17.04.14.
 */
public class MD5 {

    public String getMD5String(String source) {
        String res = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(source.getBytes(), 0, source.length());

            String md5 = convertToHex(md.digest());
            res = md5;
            md.reset();
        } catch (Exception e) {
        }

        return res;
    }

    public String getMD5(String source) {
        String p = getMD5String(source);
        p = p + Constants.SECURITY_KEY;
        p = getMD5String(p);
        return p;
    }

    private static String convertToHex(byte[] srcData) {
        StringBuilder sbuffer = new StringBuilder();
        for (int i = 0; i < srcData.length; i++) {
            int flag = (srcData[i] >>> 4) & 0x0F;
            int twoHalf = 0;
            do {
                if ((0 <= flag) && (flag <= 9)) {
                    sbuffer.append((char) ('0' + flag));
                } else {
                    sbuffer.append((char) ('a' + (flag - 10)));
                }
                flag = srcData[i] & 0x0F;
            } while (twoHalf++ < 1);
        }
        return sbuffer.toString();
    }
}
