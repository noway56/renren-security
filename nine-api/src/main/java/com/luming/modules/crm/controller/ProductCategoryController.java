package com.luming.modules.crm.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.ProductCategoryEntity;
import com.luming.modules.crm.form.ProductCategoryForm;
import com.luming.modules.crm.form.ProductCategoryPageForm;
import com.luming.modules.crm.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 产品类别
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/product/category")
@Api(tags = "产品类别")
@Slf4j
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("产品类别列表")
    public R page(@RequestBody ProductCategoryPageForm productCategoryPage){
        log.info("产品类别列表param: {}", productCategoryPage);
        ValidatorUtils.validateEntity(productCategoryPage);

        Page<ProductCategoryEntity> page = new Page<>();
        page.setCurrent(productCategoryPage.getPage());
        page.setSize(productCategoryPage.getPageSize());

        QueryWrapper<ProductCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", productCategoryPage.getTenantId());

        IPage<ProductCategoryEntity> pageList = productCategoryService.page(page, queryWrapper);
        pageList.getRecords().stream().forEach(
                item ->{
                    log.info("item: {}", JSON.toJSONString(item));
                    int count = item.getLevel();
                    ProductCategoryEntity current =
                            productCategoryService.getById(item.getCategoryId());
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
                            current = productCategoryService.getById(current.getParentId());
                        }
                    }
                }
        );
        page.setTotal(pageList.getTotal());
        log.info("产品类别列表result: {}", pageList);
        return R.ok().put("data", pageList);
    }

    @PostMapping("/list")
    @ApiOperation("查询产品类别列表")
    public R list(@RequestBody ProductCategoryEntity productCategory){
        log.info("查询产品类别列表param: {}", productCategory);
        QueryWrapper<ProductCategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(productCategory);
        List<ProductCategoryEntity> data =
                productCategoryService.list(queryWrapper);
        return R.ok().put("data", data);
    }
    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("产品类别详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProductCategoryEntity productCategory = productCategoryService.getById(tenantId);

        return R.ok().put("productCategory", productCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("产品类别保存")
    public R save(@RequestBody ProductCategoryForm productCategoryForm){
        log.info("产品类别保存param: {}", productCategoryForm);
        ValidatorUtils.validateEntity(productCategoryForm);

        ProductCategoryEntity productCategory = new ProductCategoryEntity();
        BeanUtils.copyProperties(productCategoryForm, productCategory);
        return productCategoryService.save(productCategory)
            ? R.ok()
            : R.error();
    }


    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("产品类别修改")
    public R update(@RequestBody ProductCategoryEntity productCategory){
        ValidatorUtils.validateEntity(productCategory);
        UpdateWrapper
                <ProductCategoryEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("tenant_id", productCategory.getTenantId());
        updateWrapper.eq("category_id", productCategory.getCategoryId());
        return productCategoryService.update(productCategory, updateWrapper)?
            R.ok() : R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("产品类别删除")
    public R delete(@RequestBody Long[] categoryIds){
        // 检查这些categoryId是否为其他类别的父级别
        QueryWrapper<ProductCategoryEntity>
            wrapper = new QueryWrapper<>();
        wrapper.in("parent_id", categoryIds);
        long count = productCategoryService.count(wrapper);
        if(count > 0){
            return R.error("存在子类，无法删除");
        }

        QueryWrapper<ProductCategoryEntity>
            queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id", categoryIds);
        return productCategoryService.remove(queryWrapper)?
            R.ok(): R.error();
    }

}
