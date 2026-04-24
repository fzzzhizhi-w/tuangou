package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.AddressEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {
}
