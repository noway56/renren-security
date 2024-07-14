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

import com.luming.modules.lis.entity.CheckSpecEntity;
import com.luming.modules.lis.service.CheckSpecService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检测指标
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checkspec")
public class CheckSpecController {
    @Autowired
    private CheckSpecService checkSpecService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checkspec:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkSpecService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checkspec:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckSpecEntity checkSpec = checkSpecService.getById(tenantId);

        return R.ok().put("checkSpec", checkSpec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checkspec:save")
    public R save(@RequestBody CheckSpecEntity checkSpec){
        checkSpecService.save(checkSpec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checkspec:update")
    public R update(@RequestBody CheckSpecEntity checkSpec){
        ValidatorUtils.validateEntity(checkSpec);
        checkSpecService.updateById(checkSpec);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checkspec:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkSpecService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
