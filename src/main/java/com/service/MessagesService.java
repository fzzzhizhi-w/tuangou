package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.MessagesEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface MessagesService extends IService<MessagesEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<MessagesEntity> ew);
}
