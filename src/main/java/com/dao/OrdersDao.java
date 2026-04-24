package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.OrdersEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDao extends BaseMapper<OrdersEntity> {
}
