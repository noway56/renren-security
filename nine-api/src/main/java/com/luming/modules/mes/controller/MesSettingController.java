package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialEntity;
import com.luming.modules.mes.entity.MesSettingEntity;
import com.luming.modules.mes.form.MaterialPageForm;
import com.luming.modules.mes.form.MesSettingPageForm;
import com.luming.modules.mes.service.MaterialService;
import com.luming.modules.mes.service.MesSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 原材料
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/setting")
@Api(tags = "配置")
@Slf4j
public class MesSettingController {
    @Autowired
    private MesSettingService mesSettingService;

    /**
     * 原材料列表
     */
    @PostMapping("/page")
    @ApiOperation("mes配置列表")
    public R page(@RequestBody MesSettingPageForm mesSettingPageForm){
        log.info("mes配置列表param: {}", mesSettingPageForm);
        ValidatorUtils.validateEntity(mesSettingPageForm);

        Page<MesSettingEntity> page = new Page<>();
        page.setCurrent(mesSettingPageForm.getPage());
        page.setSize(mesSettingPageForm.getPageSize());

        QueryWrapper<MesSettingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", mesSettingPageForm.getTenantId());
        IPage<MesSettingEntity> pageList
            = mesSettingService.page(page, queryWrapper);

        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("mes配置列表查询")
    public R list(@RequestBody MesSettingEntity mesSetting){
        log.info("mes配置列表param: {}", mesSetting);
        QueryWrapper<MesSettingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(mesSetting);
        return R.ok().put("data", mesSettingService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        MesSettingEntity mesSetting = mesSettingService.getById(tenantId);

        return R.ok().put("data", mesSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MesSettingEntity mesSetting){
        mesSettingService.save(mesSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MesSettingEntity mesSetting){
        ValidatorUtils.validateEntity(mesSetting);
        mesSettingService.updateById(mesSetting);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] mesSettingIds) {
        return mesSettingService.removeByIds(Arrays.asList(mesSettingIds)) ?
                R.ok() : R.error();
    }


}
