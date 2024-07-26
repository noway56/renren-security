package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.FormulaItemEntity;
import com.luming.modules.mes.form.FormulaItemPageForm;
import com.luming.modules.mes.service.FormulaItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 配方子项
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/formula/item")
@Api(tags = "配方子项")
@Slf4j
public class FormulaItemController {
    @Autowired
    private FormulaItemService formulaItemService;

    /**
     * 配方子项分页
     */
    @PostMapping("/page")
    @ApiOperation("配方子项分页查询")
    public R page(@RequestBody FormulaItemPageForm formulaItemPage){
        log.info("配方子项列表param: {}", formulaItemPage);
        ValidatorUtils.validateEntity(formulaItemPage);

        Page<FormulaItemEntity> page = new Page<>();
        page.setCurrent(formulaItemPage.getPage());
        page.setSize(formulaItemPage.getPageSize());

        QueryWrapper<FormulaItemEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", formulaItemPage.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(formulaItemPage.getInput()), "name", formulaItemPage.getInput());

        IPage<FormulaItemEntity> pageList = formulaItemService.page(page, queryWrapper);
        page.setTotal(pageList.getTotal());
        log.info("配方子项列表result: {}", pageList.getRecords());
        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("配方子项列表查询")
    public R list(@RequestBody FormulaItemEntity formulaItem){
        log.info("配方子项列表param: {}", formulaItem);
        QueryWrapper<FormulaItemEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(formulaItem);
        return R.ok().put("data", formulaItemService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("配方子项详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        FormulaItemEntity formulaItem = formulaItemService.getById(tenantId);

        return R.ok().put("material", formulaItem);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("配方子项保存")
    public R save(@RequestBody FormulaItemEntity formulaItem){
        formulaItemService.save(formulaItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("配方子项修改")
    public R update(@RequestBody FormulaItemEntity formulaItem){
        ValidatorUtils.validateEntity(formulaItem);
        formulaItemService.updateById(formulaItem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("配方子项批量删除")
    public R delete(@RequestBody Long[] formulaItemIds) {
        return formulaItemService.removeByIds(Arrays.asList(formulaItemIds)) ?
                R.ok() : R.error();
    }


}
