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

import com.luming.modules.lis.entity.CheckTemplateEntity;
import com.luming.modules.lis.service.CheckTemplateService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检查模板
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checktemplate")
public class CheckTemplateController {
    @Autowired
    private CheckTemplateService checkTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checktemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checktemplate:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckTemplateEntity checkTemplate = checkTemplateService.getById(tenantId);

        return R.ok().put("checkTemplate", checkTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checktemplate:save")
    public R save(@RequestBody CheckTemplateEntity checkTemplate){
        checkTemplateService.save(checkTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checktemplate:update")
    public R update(@RequestBody CheckTemplateEntity checkTemplate){
        ValidatorUtils.validateEntity(checkTemplate);
        checkTemplateService.updateById(checkTemplate);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checktemplate:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkTemplateService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
