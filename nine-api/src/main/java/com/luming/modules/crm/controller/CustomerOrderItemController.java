package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerOrderItemEntity;
import com.luming.modules.crm.service.CustomerOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 销售订单明细
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customerorderitem")
public class CustomerOrderItemController {
    @Autowired
    private CustomerOrderItemService customerOrderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerOrderItemEntity customerOrderItem = customerOrderItemService.getById(tenantId);

        return R.ok().put("customerOrderItem", customerOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerOrderItemEntity customerOrderItem){
        customerOrderItemService.save(customerOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerOrderItemEntity customerOrderItem){
        ValidatorUtils.validateEntity(customerOrderItem);
        customerOrderItemService.updateById(customerOrderItem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerOrderItemService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
