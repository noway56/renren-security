package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialCategoryEntity;
import com.luming.modules.mes.entity.MaterialEntity;
import com.luming.modules.mes.form.MaterialPageForm;
import com.luming.modules.mes.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 原材料
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/material")
@Api(tags = "原材料")
@Slf4j
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    /**
     * 原材料列表
     */
    @PostMapping("/page")
    @ApiOperation("原材料列表")
    public R page(@RequestBody MaterialPageForm materialPageForm){
        log.info("原材料列表param: {}", materialPageForm);
        ValidatorUtils.validateEntity(materialPageForm);

        Page<MaterialEntity> page = new Page<>();
        page.setCurrent(materialPageForm.getPage());
        page.setSize(materialPageForm.getPageSize());

        QueryWrapper<MaterialEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", materialPageForm.getTenantId());
        IPage<MaterialEntity> pageList
            = materialService.page(page, queryWrapper);

        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("原材料列表查询")
    public R list(@RequestBody MaterialEntity material){
        log.info("原材料列表param: {}", material);
        QueryWrapper<MaterialEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(material);
        return R.ok().put("data", materialService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        MaterialEntity material = materialService.getById(tenantId);

        return R.ok().put("material", material);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialEntity material){
        materialService.save(material);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialEntity material){
        ValidatorUtils.validateEntity(material);
        materialService.updateById(material);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        materialService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
