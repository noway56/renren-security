package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.ProviderAccountFlowEntity;
import com.luming.modules.crm.service.ProviderAccountFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 供应商账户流水
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/provideraccountflow")
public class ProviderAccountFlowController {
    @Autowired
    private ProviderAccountFlowService providerAccountFlowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = providerAccountFlowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProviderAccountFlowEntity providerAccountFlow = providerAccountFlowService.getById(tenantId);

        return R.ok().put("providerAccountFlow", providerAccountFlow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProviderAccountFlowEntity providerAccountFlow){
        providerAccountFlowService.save(providerAccountFlow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProviderAccountFlowEntity providerAccountFlow){
        ValidatorUtils.validateEntity(providerAccountFlow);
        providerAccountFlowService.updateById(providerAccountFlow);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        providerAccountFlowService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
