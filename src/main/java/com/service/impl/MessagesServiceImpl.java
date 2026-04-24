package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.MessagesDao;
import com.entity.MessagesEntity;
import com.service.MessagesService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("messagesService")
public class MessagesServiceImpl extends ServiceImpl<MessagesDao, MessagesEntity> implements MessagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<MessagesEntity> ew) {
        IPage<MessagesEntity> page = this.page(new Query<MessagesEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
