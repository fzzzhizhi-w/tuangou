package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.CartEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartDao extends BaseMapper<CartEntity> {
}
