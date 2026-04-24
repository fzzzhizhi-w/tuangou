package com.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;

public class MPUtil {

    public static <T> QueryWrapper<T> likeOrEq(QueryWrapper<T> ew, T entity) {
        return ew;
    }

    public static <T> QueryWrapper<T> between(QueryWrapper<T> ew, Map<String, Object> params) {
        return ew;
    }

    public static <T> QueryWrapper<T> sort(QueryWrapper<T> ew, Map<String, Object> params) {
        if (params != null && params.containsKey("sort")) {
            String sort = String.valueOf(params.get("sort"));
            String order = params.containsKey("order") ? String.valueOf(params.get("order")) : "asc";
            if ("desc".equalsIgnoreCase(order)) {
                ew.orderByDesc(sort);
            } else {
                ew.orderByAsc(sort);
            }
        }
        return ew;
    }
}
