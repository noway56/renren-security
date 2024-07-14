package com.luming.modules.crm.controller;

import java.util.Arrays;
import java.util.Map;

import com.luming.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luming.modules.crm.entity.CustomerContactEntity;
import com.luming.modules.crm.service.CustomerContactService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 客户联系人
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customercontact")
public class CustomerContactController {
    @Autowired
    private CustomerContactService customerContactService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerContactService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerContactEntity customerContact = customerContactService.getById(tenantId);

        return R.ok().put("customerContact", customerContact);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerContactEntity customerContact){
        customerContactService.save(customerContact);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerContactEntity customerContact){
        ValidatorUtils.validateEntity(customerContact);
        customerContactService.updateById(customerContact);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerContactService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
