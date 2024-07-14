package com.luming.modules.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerEntity;
import com.luming.modules.crm.form.CustomerDirectForm;
import com.luming.modules.crm.form.CustomerFromCompanyForm;
import com.luming.modules.crm.form.CustomerPageForm;
import com.luming.modules.crm.service.CustomerService;
import com.luming.modules.oa.entity.CompanyEntity;
import com.luming.modules.oa.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 租户管理
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("man/crm/customer")
@Api(tags="客户管理接口")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CompanyService companyService;

    /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("客户列表分页")
    public R page(@RequestBody CustomerPageForm customerPage){
        log.info("客户列表param: {}", customerPage);
        ValidatorUtils
                .validateEntity(customerPage);

        Page<CustomerEntity> page = new Page<>();
        page.setCurrent(customerPage.getPage());
        page.setSize(customerPage.getPageSize());

        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", customerPage.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(customerPage.getInput()), "name", customerPage.getInput());

        IPage<CustomerEntity> data = customerService.page(page, queryWrapper);

        page.setTotal(data.getTotal());
        log.info("客户列表result: {}", page);
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("客户列表")
    public R list(@RequestBody CustomerEntity customer){
        log.info("客户列表param: {}", customer);
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(customer);
        return R.ok().put("data", customerService.list(queryWrapper));
    }

    /**
     * 信息
     */
    @PostMapping("/info/{customerId}")
    @ApiOperation("客户详情")
    public R info(@PathVariable("customerId") Long customerId){
        CustomerEntity customer = customerService.getById(customerId);

        return R.ok().put("customer", customer);
    }

    /**
     * 直接添加客户
     */
    @PostMapping("/addDirect")
    @ApiOperation("直接新增客户")
    public R saveDirect(@RequestBody CustomerDirectForm customer){
        // 添加公司
        log.info("save direct customer:{}",  customer);
        ValidatorUtils.validateEntity(customer);

        CompanyEntity company = new CompanyEntity();
        BeanUtils.copyProperties(customer, company);
        companyService.save(company);
        // 通过公司信息添加客户
        QueryWrapper<CompanyEntity> companyEntityQueryWrapper
                = new QueryWrapper<>();
        companyEntityQueryWrapper.eq("name", company.getName());
        CompanyEntity companyEntity = companyService.getOne(companyEntityQueryWrapper);
        CustomerEntity
                customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerEntity.setCoreProduct(customer.getCustomerCoreProduct());
        customerEntity.setCompanyId(companyEntity.getCompanyId());
        return customerService.save(customerEntity)?
                R.ok():R.error();
    }

    /**
     * 通过公司信息添加客户
     * @param customer
     * @return
     */
    @PostMapping("/addFromCompany")
    @ApiOperation("通过公司信息新增客户")
    public R saveFromCompany(@RequestBody CustomerFromCompanyForm customer){
        log.info("save from company customer:{}",  customer);
        // 修改公司类型
        CompanyEntity companyEntity = companyService.getById(customer.getCompanyId());
        if(companyEntity.getCompanyType()==0 ||companyEntity.getCompanyType() == 3){
            companyEntity.setCompanyType(companyEntity.getCompanyType()+1);
            companyService.updateById(companyEntity);
        }

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerEntity.setCoreProduct(customer.getCustomerCoreProduct());
        log.info("save customer:{}",  customerEntity);
        return customerService.save(customerEntity)?
                R.ok():R.error();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改客户信息")
    public R update(@RequestBody CustomerEntity customer){
        ValidatorUtils.validateEntity(customer);
        customerService.updateById(customer);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除客户")
    public R delete(@RequestBody Long[] customerIds){
        customerService.removeByIds(Arrays.asList(customerIds));

        return R.ok();
    }

}
