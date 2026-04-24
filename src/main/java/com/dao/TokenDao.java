package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
}
