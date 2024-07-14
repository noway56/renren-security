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

import com.luming.modules.lis.entity.CheckRecordEntity;
import com.luming.modules.lis.service.CheckRecordService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检测记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checkrecord")
public class CheckRecordController {
    @Autowired
    private CheckRecordService checkRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checkrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checkrecord:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckRecordEntity checkRecord = checkRecordService.getById(tenantId);

        return R.ok().put("checkRecord", checkRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checkrecord:save")
    public R save(@RequestBody CheckRecordEntity checkRecord){
        checkRecordService.save(checkRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checkrecord:update")
    public R update(@RequestBody CheckRecordEntity checkRecord){
        ValidatorUtils.validateEntity(checkRecord);
        checkRecordService.updateById(checkRecord);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checkrecord:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkRecordService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
