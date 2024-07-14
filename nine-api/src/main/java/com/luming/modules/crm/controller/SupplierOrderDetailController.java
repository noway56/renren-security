package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.SupplierOrderDetailEntity;
import com.luming.modules.crm.service.SupplierOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 采购订单明细
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/supplierorderdetail")
public class SupplierOrderDetailController {
    @Autowired
    private SupplierOrderDetailService supplierOrderDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supplierOrderDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        SupplierOrderDetailEntity supplierOrderDetail = supplierOrderDetailService.getById(tenantId);

        return R.ok().put("supplierOrderDetail", supplierOrderDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SupplierOrderDetailEntity supplierOrderDetail){
        supplierOrderDetailService.save(supplierOrderDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SupplierOrderDetailEntity supplierOrderDetail){
        ValidatorUtils.validateEntity(supplierOrderDetail);
        supplierOrderDetailService.updateById(supplierOrderDetail);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        supplierOrderDetailService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
