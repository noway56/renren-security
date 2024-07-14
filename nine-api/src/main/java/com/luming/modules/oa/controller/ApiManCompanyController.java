/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.annotation.Login;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerEntity;
import com.luming.modules.crm.entity.ProviderEntity;
import com.luming.modules.crm.service.CustomerService;
import com.luming.modules.crm.service.ProviderService;
import com.luming.modules.oa.entity.CompanyEntity;
import com.luming.modules.oa.form.*;
import com.luming.modules.oa.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 管理端公司接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/man/company")
@Api(tags="管理端公司管理接口")
@Slf4j
public class ApiManCompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProviderService providerService;

    @Login
    @PostMapping("page")
    @ApiOperation("公司列表")
    public R page(@RequestBody CompanyPageForm companyPageForm) {
        ValidatorUtils
                .validateEntity(companyPageForm);

        Page<CompanyEntity> page = new Page<>();
        page.setCurrent(companyPageForm.getPage());
        page.setSize(companyPageForm.getPageSize());

        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", companyPageForm.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(companyPageForm.getInput()), "name", companyPageForm.getInput());

        IPage<CompanyEntity> data = companyService.page(page, queryWrapper);

        page.setTotal(data.getTotal());
        return R.ok().put("data", page);

    }

    @Login
    @PostMapping("list")
    @ApiOperation("公司列表")
    public R list(@RequestBody CompanyEntity company) {
        log.info("公司列表:{}", company);
        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(company);
        return R.ok().put("data", companyService.list(queryWrapper));
    }

    @Login
    @PostMapping("internals")
    @ApiOperation("内部公司列表")
    public R internals(@RequestBody TenantForm tenantForm){
        log.info("tenantId:{}", tenantForm.getTenantId());
        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", tenantForm.getTenantId());
        queryWrapper.eq("is_internal", 1);
        List<CompanyEntity> data = companyService.list(queryWrapper);
        return R.ok().put("data", data);
    }

    @Login
    @PostMapping("noneCustomers")
    @ApiOperation("非客户公司列表")
    public R noneCustomers(@RequestBody TenantForm tenantForm){
        log.info("tenantId:{}", tenantForm.getTenantId());
        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", tenantForm.getTenantId());
        List<CompanyEntity> companyData = companyService.list(queryWrapper);

        log.info("noneCustomers 1, companyData:{}", companyData);

        QueryWrapper<CustomerEntity> customerQueryWrapper = new QueryWrapper<>();
        customerQueryWrapper.eq("tenant_id", tenantForm.getTenantId());
        List<CustomerEntity> customerData = customerService.list(customerQueryWrapper);

        log.info("noneCustomers 2, customerData:{}", customerData);

        List<CompanyEntity> data = companyData.stream()
                .filter(company -> !customerData.stream().anyMatch(customer -> customer.getCompanyId().equals(company.getCompanyId())))
                .collect(Collectors.toList());
        log.info("noneCustomers 3, data:{}", data);
        return R.ok().put("data", data);
    }

    @Login
    @PostMapping("noneProviders")
    @ApiOperation("非客户公司列表")
    public R noneProviders(@RequestBody TenantForm tenantForm){
        log.info("tenantId:{}", tenantForm.getTenantId());
        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", tenantForm.getTenantId());
        List<CompanyEntity> companyData = companyService.list(queryWrapper);

        QueryWrapper<ProviderEntity> providerQueryWrapper = new QueryWrapper<>();
        providerQueryWrapper.eq("tenant_id", tenantForm.getTenantId());
        List<ProviderEntity> providerData = providerService.list(providerQueryWrapper);

        List<CompanyEntity> data = companyData.stream()
                .filter(company -> !providerData.stream().anyMatch(provider -> provider.getCompanyId().equals(company.getCompanyId())))
                .collect(Collectors.toList());
        return R.ok().put("data", data);
    }

    /**
     * 新增公司
     * @param form
     * @return
     */
    @Login
    @PostMapping("save")
    @ApiOperation("新增公司")
    public R save(@RequestBody CompanyForm form) {
        log.info("save, company:{}", form);
        ValidatorUtils.validateEntity(form);

        CompanyEntity company = new CompanyEntity();
        BeanUtils.copyProperties(form, company);

        return companyService.save(company) ? R.ok() : R.error();
    }

    @Login
    @PostMapping("update")
    @ApiOperation("更新公司")
    public R update(@RequestBody CompanyUpdateForm form) {
        log.info("update, company:{}", form);
        ValidatorUtils.validateEntity(form);

        CompanyEntity company = new CompanyEntity();
        BeanUtils.copyProperties(form, company);

        UpdateWrapper<CompanyEntity> updateWrapper = new UpdateWrapper
                <CompanyEntity>()
                .eq("tenant_id", company.getTenantId())
                .eq("company_id", company.getCompanyId());

        return companyService.update(company, updateWrapper)?
                R.ok() : R.error();
    }

    @Login
    @PostMapping("get")
    @ApiOperation("获取公司")
    public R get(@RequestBody CompanyQuery query) {
        log.info("get, query:{}", query);
        ValidatorUtils.validateEntity(query);

        CompanyEntity company = companyService.getOne(
                new QueryWrapper<CompanyEntity>()
                        .eq("tenant_id", query.getTenantId())
                        .eq("company_id", query.getCompanyId())
        );

        return R.ok().put("company", company);
    }

    @Login
    @PostMapping("delete")
    @ApiOperation("删除公司")
    public R delete(@RequestBody Long[] ids) {
        return customerService.removeByIds(Arrays.asList(ids))?
                R.ok() : R.error();
    }

}
