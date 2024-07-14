package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialEntity;
import com.luming.modules.mes.entity.RecipeItemEntity;
import com.luming.modules.mes.form.RecipeItemPageForm;
import com.luming.modules.mes.service.RecipeItemService;
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
@RequestMapping("mes/recipe/item")
@Api(tags = "配方子项")
@Slf4j
public class RecipeItemController {
    @Autowired
    private RecipeItemService recipeItemService;

    /**
     * 配方子项分页
     */
    @PostMapping("/page")
    @ApiOperation("配方子项分页查询")
    public R page(@RequestBody RecipeItemPageForm recipeItemPage){
        log.info("配方子项列表param: {}", recipeItemPage);
        ValidatorUtils.validateEntity(recipeItemPage);

        Page<RecipeItemEntity> page = new Page<>();
        page.setCurrent(recipeItemPage.getPage());
        page.setSize(recipeItemPage.getPageSize());

        QueryWrapper<RecipeItemEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", recipeItemPage.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(recipeItemPage.getInput()), "name", recipeItemPage.getInput());

        IPage<RecipeItemEntity> pageList = recipeItemService.page(page, queryWrapper);
        page.setTotal(pageList.getTotal());
        log.info("配方子项列表result: {}", pageList.getRecords());
        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("配方子项列表查询")
    public R list(@RequestBody RecipeItemEntity recipeItem){
        log.info("配方子项列表param: {}", recipeItem);
        QueryWrapper<RecipeItemEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(recipeItem);
        return R.ok().put("data", recipeItemService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("配方子项详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        RecipeItemEntity recipeItem = recipeItemService.getById(tenantId);

        return R.ok().put("material", recipeItem);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("配方子项保存")
    public R save(@RequestBody RecipeItemEntity recipeItem){
        recipeItemService.save(recipeItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("配方子项修改")
    public R update(@RequestBody RecipeItemEntity recipeItem){
        ValidatorUtils.validateEntity(recipeItem);
        recipeItemService.updateById(recipeItem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("配方子项批量删除")
    public R delete(@RequestBody Long[] materialIds) {
        return recipeItemService.removeByIds(Arrays.asList(materialIds)) ?
                R.ok() : R.error();
    }


}
