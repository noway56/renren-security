package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.RecipeEntity;
import com.luming.modules.mes.entity.RecipeItemEntity;
import com.luming.modules.mes.form.RecipePageForm;
import com.luming.modules.mes.service.RecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 配方
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/recipe")
@Api(tags = "配方")
@Slf4j
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    /**
     * 配方分页
     */
    @PostMapping("/page")
    @ApiOperation("配方分页查询")
    public R page(@RequestBody RecipePageForm recipePage){
        log.info("配方列表param: {}", recipePage);
        ValidatorUtils.validateEntity(recipePage);

        Page<RecipeEntity> page = new Page<>();
        page.setCurrent(recipePage.getPage());
        page.setSize(recipePage.getPageSize());

        QueryWrapper<RecipeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", recipePage.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(recipePage.getInput()), "name", recipePage.getInput());

        IPage<RecipeEntity> pageList = recipeService.page(page, queryWrapper);
        page.setTotal(pageList.getTotal());
        log.info("配方列表result: {}", pageList.getRecords());
        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("配方列表查询")
    public R list(@RequestBody RecipeEntity recipe){
        log.info("配方列表param: {}", recipe);
        QueryWrapper<RecipeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(recipe);
        return R.ok().put("data", recipeService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("配方详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        RecipeEntity recipe = recipeService.getById(tenantId);

        return R.ok().put("material", recipe);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("配方保存")
    public R save(@RequestBody RecipeEntity recipe){
        recipeService.save(recipe);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("配方修改")
    public R update(@RequestBody RecipeEntity recipe){
        ValidatorUtils.validateEntity(recipe);
        recipeService.updateById(recipe);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("配方批量删除")
    public R delete(@RequestBody Long[] materialIds) {
        return recipeService.removeByIds(Arrays.asList(materialIds)) ?
                R.ok() : R.error();
    }


}
