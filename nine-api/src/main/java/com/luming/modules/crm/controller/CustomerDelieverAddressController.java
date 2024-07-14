package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerDelieverAddressEntity;
import com.luming.modules.crm.service.CustomerDelieverAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 客户送货地址管理
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customerdelieveraddress")
public class CustomerDelieverAddressController {
    @Autowired
    private CustomerDelieverAddressService customerDelieverAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerDelieverAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerDelieverAddressEntity customerDelieverAddress = customerDelieverAddressService.getById(tenantId);

        return R.ok().put("customerDelieverAddress", customerDelieverAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerDelieverAddressEntity customerDelieverAddress){
        customerDelieverAddressService.save(customerDelieverAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerDelieverAddressEntity customerDelieverAddress){
        ValidatorUtils.validateEntity(customerDelieverAddress);
        customerDelieverAddressService.updateById(customerDelieverAddress);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerDelieverAddressService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
