package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.NewsEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface NewsService extends IService<NewsEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<NewsEntity> ew);
}
