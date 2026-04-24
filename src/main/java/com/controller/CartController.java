package com.controller;

import com.entity.CartEntity;
import com.service.CartService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CartEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<CartEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        MPUtil.sort(ew, params);
        PageUtils page = cartService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CartEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<CartEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        MPUtil.sort(ew, params);
        PageUtils page = cartService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", cartService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody CartEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        entity.setUserid(userId);
        CartEntity exist = cartService.getOne(
            new QueryWrapper<CartEntity>()
                .eq("userid", userId)
                .eq("goodid", entity.getGoodid())
        );
        if (exist != null) {
            exist.setBuynumber(exist.getBuynumber() + (entity.getBuynumber() == null ? 1 : entity.getBuynumber()));
            cartService.updateById(exist);
        } else {
            entity.setId(new Date().getTime());
            entity.setAddtime(new Date());
            cartService.save(entity);
        }
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody CartEntity entity) {
        cartService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        cartService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
