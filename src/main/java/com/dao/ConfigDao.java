package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigDao extends BaseMapper<ConfigEntity> {
}
