/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.oa.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luming.annotation.Login;
import com.luming.common.utils.R;
import com.luming.modules.oa.entity.DeptEntity;
import com.luming.modules.oa.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 管理端用户接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/man/dept")
@Api(tags="管理端部门管理接口")
@Slf4j
public class ApiManDeptController {
    @Autowired
    private DeptService deptService;

    @Login
    @PostMapping("list")
    @ApiOperation("部门列表")
    public R list(@RequestBody HashMap<String, Object> params) {
        log.info("deptList, params:{}", params);
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setTenantId(Long.getLong(params.get("tenant").toString()));
        Wrapper<DeptEntity> deptWapper = new QueryWrapper<DeptEntity>(deptEntity);
        return R.ok().put("data", deptService.list(deptWapper));
    }

}
