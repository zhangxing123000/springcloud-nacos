package com.zx.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.common.AppResult;
import com.zx.common.AppResultBuilder;
import com.zx.common.ResultCode;
import com.zx.user.bo.SaveUserBO;
import com.zx.user.entity.SysUser;
import com.zx.user.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxing
 * @since 2020-05-22
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/queryUserById")
    public String queryUserById(String userId) {
        return sysUserService.getById(userId).toString();
    }

    @PostMapping("/saveUser")
    public AppResult<String> saveUser(@Validated @RequestBody SaveUserBO bo){

        Integer count = sysUserService.count(new QueryWrapper<SysUser>().eq("name", bo.getName()));
        if(count > 0) {
            return AppResultBuilder.error(ResultCode.USER_HAS_EXISTED);
        }

        SysUser  user = new SysUser();
        user.setName(bo.getName());
        user.setSex(Integer.valueOf(bo.getSex()));
        user.setBirthday(LocalDate.parse(bo.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        user.setCreateTime(LocalDateTime.now());
        sysUserService.save(user);
        return AppResultBuilder.success(user.getId());

    }
}
