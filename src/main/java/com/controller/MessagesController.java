package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.MessagesEntity;
import com.service.MessagesService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MessagesEntity entity) {
        QueryWrapper<MessagesEntity> ew = new QueryWrapper<>();
        if (entity.getUserid() != null) {
            ew.eq("userid", entity.getUserid());
        }
        MPUtil.sort(ew, params);
        PageUtils page = messagesService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, MessagesEntity entity) {
        QueryWrapper<MessagesEntity> ew = new QueryWrapper<>();
        MPUtil.sort(ew, params);
        PageUtils page = messagesService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", messagesService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody MessagesEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        entity.setId(new Date().getTime());
        entity.setUserid(userId);
        entity.setAddtime(new Date());
        messagesService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody MessagesEntity entity) {
        messagesService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        messagesService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
