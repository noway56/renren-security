/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.sys.controller;


import com.luming.modules.sys.service.AccountService;
import com.luming.modules.sys.service.TokenService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理端用户接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/man/menu")
@Api(tags="管理端用户接口")
@Slf4j
public class ApiManMenuController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TokenService tokenService;


}
