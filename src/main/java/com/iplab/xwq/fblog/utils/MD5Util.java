package com.iplab.xwq.fblog.utils;

import java.security.MessageDigest;

public class MD5Util {
    private static final String hexDigits[] = {"0","1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexSring(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0;i < b.length;i++){
            resultSb.append(byteToHexSring(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexSring(byte b){
        int n = b;
        if (n < 0) n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin,String charsetname){
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexSring(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexSring(md.digest(resultString.getBytes(charsetname)));
        }catch (Exception e){

        }
        return resultString;
    }
}
