package com.luming.modules.lis.controller;

import java.util.Arrays;
import java.util.Map;

import com.luming.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luming.modules.lis.entity.CheckTemplateItemEntity;
import com.luming.modules.lis.service.CheckTemplateItemService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检查模板明细
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checktemplateitem")
public class CheckTemplateItemController {
    @Autowired
    private CheckTemplateItemService checkTemplateItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checktemplateitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkTemplateItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checktemplateitem:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckTemplateItemEntity checkTemplateItem = checkTemplateItemService.getById(tenantId);

        return R.ok().put("checkTemplateItem", checkTemplateItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checktemplateitem:save")
    public R save(@RequestBody CheckTemplateItemEntity checkTemplateItem){
        checkTemplateItemService.save(checkTemplateItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checktemplateitem:update")
    public R update(@RequestBody CheckTemplateItemEntity checkTemplateItem){
        ValidatorUtils.validateEntity(checkTemplateItem);
        checkTemplateItemService.updateById(checkTemplateItem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checktemplateitem:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkTemplateItemService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
