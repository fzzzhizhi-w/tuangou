package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.CartDao;
import com.entity.CartEntity;
import com.service.CartService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<CartEntity> ew) {
        IPage<CartEntity> page = this.page(new Query<CartEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
