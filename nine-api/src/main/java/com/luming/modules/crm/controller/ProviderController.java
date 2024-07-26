package com.luming.modules.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerEntity;
import com.luming.modules.crm.entity.ProviderEntity;
import com.luming.modules.crm.form.*;
import com.luming.modules.crm.service.ProviderService;
import com.luming.modules.oa.entity.CompanyEntity;
import com.luming.modules.oa.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 供应商
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("man/crm/provider")
@Api(value = "供应商", tags = "供应商")
@Slf4j
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private CompanyService  companyService;

    /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("供应商列表")
    public R page(@RequestBody ProviderPageForm providerPageForm){
        log.info("供应商列表param: {}", providerPageForm);
        ValidatorUtils
                .validateEntity(providerPageForm);

        Page<ProviderEntity> page = new Page<>();
        page.setCurrent(providerPageForm.getPage());
        page.setSize(providerPageForm.getPageSize());

        QueryWrapper<ProviderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", providerPageForm.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(providerPageForm.getInput()), "name", providerPageForm.getInput());

        IPage<ProviderEntity> data = providerService.page(page, queryWrapper);

        page.setTotal(data.getTotal());
        log.info("供应商列表result: {}", page);
        return R.ok().put("data", page);
    }

    /**
     * 供应商列表查询
     */
    @PostMapping("/list")
    @ApiOperation("供应商列表查询")
    public R list(@RequestBody ProviderEntity provider){
        log.info("供应商列表查询param: {}", provider);
        QueryWrapper<ProviderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(provider);
        return  R.ok().put("data", providerService.list(queryWrapper));
    }

    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("供应商详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProviderEntity provider = providerService.getById(tenantId);

        return R.ok().put("provider", provider);
    }


    /**
     * 直接添加客户
     */
    @PostMapping("/addDirect")
    @ApiOperation("直接新增供应商")
    public R saveDirect(@RequestBody ProviderDirectForm provider){
        // 添加公司
        log.info("save direct provider:{}",  provider);
        ValidatorUtils.validateEntity(provider);

        CompanyEntity company = new CompanyEntity();
        BeanUtils.copyProperties(provider, company);
        log.info("save direct provider 1. save company:{}",  company);
        Boolean savedCompany = companyService.save(company);
        if (!savedCompany){
            return R.error("保存公司信息失败");
        }
        // 通过公司信息添加供应商
        QueryWrapper<CompanyEntity> companyEntityQueryWrapper
                = new QueryWrapper<>();
        companyEntityQueryWrapper.eq("name", company.getName());
        CompanyEntity companyEntity = companyService.getOne(companyEntityQueryWrapper);
        ProviderEntity
                 providerEntity= new ProviderEntity();
        BeanUtils.copyProperties(provider, providerEntity);
        providerEntity.setCompanyId(companyEntity.getCompanyId());
        return providerService.save(providerEntity)?
                R.ok():R.error();
    }

    /**
     * 通过公司信息添加客户
     * @param provider
     * @return
     */
    @PostMapping("/addFromCompany")
    @ApiOperation("通过公司信息新增客户")
    public R saveFromCompany(@RequestBody ProviderFromCompanyForm provider){
        log.info("save from company provider:{}",  provider);
        // 修改公司类型
        CompanyEntity companyEntity = companyService.getById(provider.getCompanyId());
        if(companyEntity.getCompanyType() == 1){
            companyEntity.setCompanyType(4);
            companyService.updateById(companyEntity);
        }

        ProviderEntity providerEntity = new ProviderEntity();
        BeanUtils.copyProperties(provider, providerEntity);
        log.info("save customer:{}",  providerEntity);
        return providerService.save(providerEntity)?
                R.ok():R.error();
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("新增供应商")
    public R save(@RequestBody ProviderEntity provider){
        providerService.save(provider);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改供应商信息")
    public R update(@RequestBody ProviderEntity provider){
        ValidatorUtils.validateEntity(provider);
        providerService.updateById(provider);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除供应商")
    public R delete(@RequestBody Long[] tenantIds){
        return providerService.removeByIds(Arrays.asList(tenantIds))
                ?R.ok():R.error();
    }

}
