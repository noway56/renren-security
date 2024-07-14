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

import com.luming.modules.lis.entity.CheckItemSpecEntity;
import com.luming.modules.lis.service.CheckItemSpecService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检测项目指标
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checkitemspec")
public class CheckItemSpecController {
    @Autowired
    private CheckItemSpecService checkItemSpecService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checkitemspec:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkItemSpecService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checkitemspec:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckItemSpecEntity checkItemSpec = checkItemSpecService.getById(tenantId);

        return R.ok().put("checkItemSpec", checkItemSpec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checkitemspec:save")
    public R save(@RequestBody CheckItemSpecEntity checkItemSpec){
        checkItemSpecService.save(checkItemSpec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checkitemspec:update")
    public R update(@RequestBody CheckItemSpecEntity checkItemSpec){
        ValidatorUtils.validateEntity(checkItemSpec);
        checkItemSpecService.updateById(checkItemSpec);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checkitemspec:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkItemSpecService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
