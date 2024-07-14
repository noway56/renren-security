package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialCategoryEntity;
import com.luming.modules.mes.form.MaterialCategoryForm;
import com.luming.modules.mes.form.MaterialCategoryPageForm;
import com.luming.modules.mes.service.MaterialCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 原材料类别
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/material/category")
@Api(tags = "原材料类别")
@Slf4j
public class MaterialCategoryController {
    @Autowired
    private MaterialCategoryService materialCategoryService;

    /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("原材料类别列表")
    public R page(@RequestBody MaterialCategoryPageForm materialCategoryPage){
        log.info("原材料类别列表param: {}", materialCategoryPage);
        ValidatorUtils.validateEntity(materialCategoryPage);

        Page<MaterialCategoryEntity> page = new Page<>();
        page.setCurrent(materialCategoryPage.getPage());
        page.setSize(materialCategoryPage.getPageSize());

        QueryWrapper<MaterialCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", materialCategoryPage.getTenantId());

        IPage<MaterialCategoryEntity> pageList = materialCategoryService.page(page, queryWrapper);
        pageList.getRecords().stream().forEach(
                item ->{
                    int count = item.getLevel();
                    MaterialCategoryEntity current = item;
                    while(count > 0){
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
                            MaterialCategoryEntity parent = materialCategoryService.getById(item.getParentId());
                            current = parent;
                        }
                    }
                }
        );
        page.setTotal(pageList.getTotal());
        log.info("原材料类别列表result: {}", pageList);
        return R.ok().put("data", pageList);
    }

    @PostMapping("/list")
    @ApiOperation("查询原材料类别列表")
    public R list(@RequestBody MaterialCategoryEntity materialCategory){
        log.info("查询原材料类别列表param: {}", materialCategory);
        QueryWrapper<MaterialCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(materialCategory);
        List<MaterialCategoryEntity> data =
                materialCategoryService.list(queryWrapper);
        return R.ok().put("data", data);
    }
    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("原材料类别详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        MaterialCategoryEntity materialCategory = materialCategoryService.getById(tenantId);

        return R.ok().put("materialCategory", materialCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("原材料类别保存")
    public R save(@RequestBody MaterialCategoryForm materialCategoryForm){
        log.info("原材料类别保存param: {}", materialCategoryForm);
        ValidatorUtils.validateEntity(materialCategoryForm);

        MaterialCategoryEntity materialCategory = new MaterialCategoryEntity();
        BeanUtils.copyProperties(materialCategoryForm, materialCategory);
        return materialCategoryService.save(materialCategory)
            ? R.ok()
            : R.error();
    }


    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("原材料类别修改")
    public R update(@RequestBody MaterialCategoryEntity materialCategory){
        ValidatorUtils.validateEntity(materialCategory);
        UpdateWrapper
                <MaterialCategoryEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("tenant_id", materialCategory.getTenantId());
        updateWrapper.eq("category_id", materialCategory.getCategoryId());
        return materialCategoryService.update(materialCategory, updateWrapper)?
            R.ok() : R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("原材料类别删除")
    public R delete(@RequestBody Long[] categoryIds){
        // 检查这些categoryId是否为其他类别的父级别
        QueryWrapper<MaterialCategoryEntity>
            wrapper = new QueryWrapper<>();
        wrapper.in("parent_id", categoryIds);
        long count = materialCategoryService.count(wrapper);
        if(count > 0){
            return R.error("存在子类，无法删除");
        }

        QueryWrapper<MaterialCategoryEntity>
            queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id", categoryIds);
        return materialCategoryService.remove(queryWrapper)?
            R.ok(): R.error();
    }

}
