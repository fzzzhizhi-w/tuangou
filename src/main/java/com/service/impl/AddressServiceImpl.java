package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.AddressDao;
import com.entity.AddressEntity;
import com.service.AddressService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<AddressEntity> ew) {
        IPage<AddressEntity> page = this.page(new Query<AddressEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
