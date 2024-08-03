package com.luming.modules.mes.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.FormulaCategoryEntity;
import com.luming.modules.mes.form.FormulaCategoryForm;
import com.luming.modules.mes.form.FormulaCategoryPageForm;
import com.luming.modules.mes.service.FormulaCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 配方类别
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/formula/category")
@Api(tags = "配方类别")
@Slf4j
public class FormulaCategoryController {
    @Autowired
    private FormulaCategoryService formulaCategoryService;

    /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("配方类别列表")
    public R page(@RequestBody FormulaCategoryPageForm formulaCategoryPage){
        log.info("配方类别列表param: {}", formulaCategoryPage);
        ValidatorUtils.validateEntity(formulaCategoryPage);

        Page<FormulaCategoryEntity> page = new Page<>();
        page.setCurrent(formulaCategoryPage.getPage());
        page.setSize(formulaCategoryPage.getPageSize());

        QueryWrapper<FormulaCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", formulaCategoryPage.getTenantId());

        IPage<FormulaCategoryEntity> pageList = formulaCategoryService.page(page, queryWrapper);
        pageList.getRecords().stream().forEach(
                item ->{
                    log.info("item: {}", JSON.toJSONString(item));
                    int count = item.getLevel();
                    FormulaCategoryEntity current =
                            formulaCategoryService.getById(item.getCategoryId());
                    while(count > 0){
                        log.info("current: {}", JSON.toJSONString(current));
                        if(count == 1){
                            item.setLevel1(current.getName());
                            break;
                        }else {
                            if(count == 2){
                                item.setLevel2(current.getName());
                            }else if(count == 3){
                                item.setLevel3(current.getName());
                            }
                            count--;
                            current = formulaCategoryService.getById(current.getParentId());
                        }
                    }
                }
        );
        page.setTotal(pageList.getTotal());
        log.info("配方类别列表result: {}", pageList);
        return R.ok().put("data", pageList);
    }

    @PostMapping("/list")
    @ApiOperation("查询配方类别列表")
    public R list(@RequestBody FormulaCategoryEntity formulaCategory){
        log.info("查询配方类别列表param: {}", formulaCategory);
        QueryWrapper<FormulaCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(formulaCategory);
        List<FormulaCategoryEntity> data =
                formulaCategoryService.list(queryWrapper);
        return R.ok().put("data", data);
    }
    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("配方类别详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        FormulaCategoryEntity formulaCategory = formulaCategoryService.getById(tenantId);

        return R.ok().put("formulaCategory", formulaCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("配方类别保存")
    public R save(@RequestBody FormulaCategoryForm formulaCategoryForm){
        log.info("配方类别保存param: {}", formulaCategoryForm);
        ValidatorUtils.validateEntity(formulaCategoryForm);

        FormulaCategoryEntity formulaCategory = new FormulaCategoryEntity();
        BeanUtils.copyProperties(formulaCategoryForm, formulaCategory);
        return formulaCategoryService.save(formulaCategory)
            ? R.ok()
            : R.error();
    }


    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("配方类别修改")
    public R update(@RequestBody FormulaCategoryEntity formulaCategory){
        ValidatorUtils.validateEntity(formulaCategory);
        UpdateWrapper
                <FormulaCategoryEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("tenant_id", formulaCategory.getTenantId());
        updateWrapper.eq("category_id", formulaCategory.getCategoryId());
        return formulaCategoryService.update(formulaCategory, updateWrapper)?
            R.ok() : R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("配方类别删除")
    public R delete(@RequestBody Long[] categoryIds){
        // 检查这些categoryId是否为其他类别的父级别
        QueryWrapper<FormulaCategoryEntity>
            wrapper = new QueryWrapper<>();
        wrapper.in("parent_id", categoryIds);
        long count = formulaCategoryService.count(wrapper);
        if(count > 0){
            return R.error("存在子类，无法删除");
        }

        QueryWrapper<FormulaCategoryEntity>
            queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id", categoryIds);
        return formulaCategoryService.remove(queryWrapper)?
            R.ok(): R.error();
    }

}
