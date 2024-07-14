package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.ProviderAccountEntity;
import com.luming.modules.crm.service.ProviderAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 供应商账户
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/provideraccount")
public class ProviderAccountController {
    @Autowired
    private ProviderAccountService providerAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = providerAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProviderAccountEntity providerAccount = providerAccountService.getById(tenantId);

        return R.ok().put("providerAccount", providerAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProviderAccountEntity providerAccount){
        providerAccountService.save(providerAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProviderAccountEntity providerAccount){
        ValidatorUtils.validateEntity(providerAccount);
        providerAccountService.updateById(providerAccount);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        providerAccountService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
