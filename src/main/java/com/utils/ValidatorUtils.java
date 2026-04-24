package com.utils;

import org.springframework.util.StringUtils;

public class ValidatorUtils {
    public static void validateEntity(Object object) {
        if (object == null) {
            throw new RuntimeException("请求参数不能为空");
        }
    }

    public static boolean isNotEmpty(String str) {
        return StringUtils.hasText(str);
    }
}
