package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersDao extends BaseMapper<UsersEntity> {
}
