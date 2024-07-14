package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.SupplierOrderEntity;
import com.luming.modules.crm.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 采购订单
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/supplierorder")
public class SupplierOrderController {
    @Autowired
    private SupplierOrderService supplierOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supplierOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        SupplierOrderEntity supplierOrder = supplierOrderService.getById(tenantId);

        return R.ok().put("supplierOrder", supplierOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SupplierOrderEntity supplierOrder){
        supplierOrderService.save(supplierOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SupplierOrderEntity supplierOrder){
        ValidatorUtils.validateEntity(supplierOrder);
        supplierOrderService.updateById(supplierOrder);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        supplierOrderService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
