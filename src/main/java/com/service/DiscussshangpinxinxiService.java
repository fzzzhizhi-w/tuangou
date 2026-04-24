package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.DiscussshangpinxinxiEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface DiscussshangpinxinxiService extends IService<DiscussshangpinxinxiEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscussshangpinxinxiEntity> ew);
}
