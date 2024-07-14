package com.luming.modules.lis.controller;

import java.util.Arrays;
import java.util.Map;

import com.luming.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luming.modules.lis.entity.CheckItemEntity;
import com.luming.modules.lis.service.CheckItemService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检测项目定义
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checkitem")
@Slf4j
@Api(tags="检测项目定义")
public class CheckItemController {
    @Autowired
    private CheckItemService checkItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checkitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checkitem:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckItemEntity checkItem = checkItemService.getById(tenantId);

        return R.ok().put("checkItem", checkItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checkitem:save")
    public R save(@RequestBody CheckItemEntity checkItem){
        checkItemService.save(checkItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checkitem:update")
    public R update(@RequestBody CheckItemEntity checkItem){
        ValidatorUtils.validateEntity(checkItem);
        checkItemService.updateById(checkItem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checkitem:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkItemService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
