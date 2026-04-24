package com.controller;

import com.entity.OrdersEntity;
import com.entity.ShangpinxinxiEntity;
import com.service.OrdersService;
import com.service.ShangpinxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ShangpinxinxiService shangpinxinxiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, OrdersEntity entity, HttpServletRequest request) {
        String role = (String) request.getSession().getAttribute("role");
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<OrdersEntity> ew = new QueryWrapper<>();
        if ("用户".equals(role)) {
            ew.eq("userid", userId);
        }
        if (entity.getStatus() != null && !entity.getStatus().isEmpty()) {
            ew.eq("status", entity.getStatus());
        }
        if (entity.getGoodname() != null && !entity.getGoodname().isEmpty()) {
            ew.like("goodname", entity.getGoodname());
        }
        MPUtil.sort(ew, params);
        PageUtils page = ordersService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, OrdersEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<OrdersEntity> ew = new QueryWrapper<>();
        ew.eq("userid", userId);
        MPUtil.sort(ew, params);
        PageUtils page = ordersService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", ordersService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody OrdersEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        entity.setId(new Date().getTime());
        entity.setUserid(userId);
        String orderid = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int)(Math.random() * 900 + 100);
        entity.setOrderid(orderid);
        entity.setStatus("未支付");
        entity.setAddtime(new Date());

        ShangpinxinxiEntity good = shangpinxinxiService.getById(entity.getGoodid());
        if (good != null) {
            if (good.getAlllimittimes() != null && good.getCurpeople() != null
                    && good.getCurpeople() >= good.getAlllimittimes()) {
                return R.error("该商品已达到团购人数上限");
            }
        }
        ordersService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody OrdersEntity entity) {
        ordersService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        ordersService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/pay/{id}")
    public R pay(@PathVariable("id") Long id) {
        OrdersEntity order = ordersService.getById(id);
        if (order == null) {
            return R.error("订单不存在");
        }
        order.setStatus("已支付");
        ordersService.updateById(order);

        ShangpinxinxiEntity good = shangpinxinxiService.getById(order.getGoodid());
        if (good != null) {
            good.setCurpeople(good.getCurpeople() == null ? 1 : good.getCurpeople() + 1);
            shangpinxinxiService.updateById(good);
        }
        return R.ok();
    }
}
