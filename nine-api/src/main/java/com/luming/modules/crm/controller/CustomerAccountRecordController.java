package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.CustomerAccountRecordEntity;
import com.luming.modules.crm.service.CustomerAccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 入账记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customeraccountrecord")
public class CustomerAccountRecordController {
    @Autowired
    private CustomerAccountRecordService customerAccountRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerAccountRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerAccountRecordEntity customerAccountRecord = customerAccountRecordService.getById(tenantId);

        return R.ok().put("customerAccountRecord", customerAccountRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerAccountRecordEntity customerAccountRecord){
        customerAccountRecordService.save(customerAccountRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerAccountRecordEntity customerAccountRecord){
        ValidatorUtils.validateEntity(customerAccountRecord);
        customerAccountRecordService.updateById(customerAccountRecord);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerAccountRecordService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
