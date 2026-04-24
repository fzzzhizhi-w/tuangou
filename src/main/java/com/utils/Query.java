package com.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.math.NumberUtils;
import java.util.Map;

public class Query<T> {
    public IPage<T> getPage(Map<String, Object> params) {
        return getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        long curPage = 1;
        long limit = 10;
        if (params.get("page") != null) {
            curPage = NumberUtils.toLong(String.valueOf(params.get("page")));
        }
        if (params.get("limit") != null) {
            limit = NumberUtils.toLong(String.valueOf(params.get("limit")));
        }
        return new Page<>(curPage, limit);
    }
}
