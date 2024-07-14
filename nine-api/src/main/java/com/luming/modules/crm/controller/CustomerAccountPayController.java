package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerAccountPayEntity;
import com.luming.modules.crm.service.CustomerAccountPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 出账记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customeraccountpay")
public class CustomerAccountPayController {
    @Autowired
    private CustomerAccountPayService customerAccountPayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerAccountPayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerAccountPayEntity customerAccountPay = customerAccountPayService.getById(tenantId);

        return R.ok().put("customerAccountPay", customerAccountPay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerAccountPayEntity customerAccountPay){
        customerAccountPayService.save(customerAccountPay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerAccountPayEntity customerAccountPay){
        ValidatorUtils.validateEntity(customerAccountPay);
        customerAccountPayService.updateById(customerAccountPay);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerAccountPayService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
