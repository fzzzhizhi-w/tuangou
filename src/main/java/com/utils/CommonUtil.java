package com.utils;

import java.util.UUID;

public class CommonUtil {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * base.length());
            sb.append(base.charAt(index));
        }
        return sb.toString();
    }

    public static String getToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
