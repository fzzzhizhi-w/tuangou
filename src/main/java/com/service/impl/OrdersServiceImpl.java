package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.OrdersDao;
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<OrdersEntity> ew) {
        IPage<OrdersEntity> page = this.page(new Query<OrdersEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
