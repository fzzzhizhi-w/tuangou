package com.controller;

import com.entity.AddressEntity;
import com.service.AddressService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, AddressEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<AddressEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        MPUtil.sort(ew, params);
        PageUtils page = addressService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, AddressEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<AddressEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        MPUtil.sort(ew, params);
        PageUtils page = addressService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", addressService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody AddressEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        entity.setId(new Date().getTime());
        entity.setUserid(userId);
        entity.setAddtime(new Date());
        if ("是".equals(entity.getIsdefault())) {
            addressService.update(null,
                new com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper<AddressEntity>()
                    .eq("userid", userId).set("isdefault", "否"));
        }
        addressService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody AddressEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        if ("是".equals(entity.getIsdefault())) {
            addressService.update(null,
                new com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper<AddressEntity>()
                    .eq("userid", userId).set("isdefault", "否"));
        }
        addressService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        addressService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
