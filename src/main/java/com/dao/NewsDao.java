package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
}
