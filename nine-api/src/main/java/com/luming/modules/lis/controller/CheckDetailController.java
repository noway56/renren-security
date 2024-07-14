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

import com.luming.modules.lis.entity.CheckDetailEntity;
import com.luming.modules.lis.service.CheckDetailService;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;



/**
 * 检测详情
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@RestController
@RequestMapping("lis/checkdetail")
public class CheckDetailController {
    @Autowired
    private CheckDetailService checkDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("lis:checkdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("lis:checkdetail:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        CheckDetailEntity checkDetail = checkDetailService.getById(tenantId);

        return R.ok().put("checkDetail", checkDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("lis:checkdetail:save")
    public R save(@RequestBody CheckDetailEntity checkDetail){
        checkDetailService.save(checkDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("lis:checkdetail:update")
    public R update(@RequestBody CheckDetailEntity checkDetail){
        ValidatorUtils.validateEntity(checkDetail);
        checkDetailService.updateById(checkDetail);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("lis:checkdetail:delete")
    public R delete(@RequestBody Long[] tenantIds){
        checkDetailService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
