/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.sys.controller;


import com.luming.annotation.Login;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.sys.entity.TokenEntity;
import com.luming.modules.sys.entity.AccountEntity;
import com.luming.modules.sys.form.LoginForm;
import com.luming.modules.sys.form.RegisterForm;
import com.luming.modules.sys.service.TokenService;
import com.luming.modules.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理端用户接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/man/account")
@Api(tags="管理端账号相关接口")
@Slf4j
public class ApiManAccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        AccountEntity user = new AccountEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        accountService.save(user);

        return R.ok();
    }

    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        log.info("login form: {}", form.toString());
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = accountService.login(form);

        return R.ok(map);
    }


    @Login
    @PostMapping("infoByToken")
    @ApiOperation(value="根据token获取用户信息", response= AccountEntity.class)
    public R userInfoByToken(@RequestBody HashMap<String, Object>params){
        log.info("params:{}", params);
        TokenEntity tokenEntity = tokenService.queryByToken(params.get("token").toString());
        AccountEntity user = accountService.getById(tokenEntity.getUserId());
        return R.ok().put("user", user);
    }


    @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestBody HashMap<String, Object>params){
        log.info("logout params:{}", params);
        TokenEntity tokenEntity = tokenService.queryByToken(params.get("token").toString());
        tokenService.expireToken(tokenEntity.getUserId());
        return R.ok();
    }

}
