package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.ProviderContactEntity;
import com.luming.modules.crm.service.ProviderContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 供应商联系人
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/providercontact")
public class ProviderContactController {
    @Autowired
    private ProviderContactService providerContactService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = providerContactService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProviderContactEntity providerContact = providerContactService.getById(tenantId);

        return R.ok().put("providerContact", providerContact);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProviderContactEntity providerContact){
        providerContactService.save(providerContact);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProviderContactEntity providerContact){
        ValidatorUtils.validateEntity(providerContact);
        providerContactService.updateById(providerContact);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        providerContactService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
