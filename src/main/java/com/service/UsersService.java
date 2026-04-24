package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.UsersEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface UsersService extends IService<UsersEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<UsersEntity> ew);
}
