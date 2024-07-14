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

import com.luming.modules.crm.entity.CustomerAccountFlowEntity;
import com.luming.modules.crm.service.CustomerAccountFlowService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 客户账户流水
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customeraccountflow")
public class CustomerAccountFlowController {
    @Autowired
    private CustomerAccountFlowService customerAccountFlowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerAccountFlowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerAccountFlowEntity customerAccountFlow = customerAccountFlowService.getById(tenantId);

        return R.ok().put("customerAccountFlow", customerAccountFlow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerAccountFlowEntity customerAccountFlow){
        customerAccountFlowService.save(customerAccountFlow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerAccountFlowEntity customerAccountFlow){
        ValidatorUtils.validateEntity(customerAccountFlow);
        customerAccountFlowService.updateById(customerAccountFlow);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerAccountFlowService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
