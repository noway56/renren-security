package com.luming.modules.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.crm.entity.ProductEntity;
import com.luming.modules.crm.form.ProductForm;
import com.luming.modules.crm.form.ProductPageForm;
import com.luming.modules.crm.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 产品
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/product")
@Api(tags = "产品")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

//    @Autowired
//    private productServiceItemService productServiceItemService;

    /**
     * 产品分页
     */
    @PostMapping("/page")
    @ApiOperation("产品分页查询")
    public R page(@RequestBody ProductPageForm productPage){
        log.info("产品列表param: {}", productPage);
        ValidatorUtils.validateEntity(productPage);

        Page<ProductEntity> page = new Page<>();
        page.setCurrent(productPage.getPage());
        page.setSize(productPage.getPageSize());

        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", productPage.getTenantId());
        queryWrapper.like(StringUtils.isNotBlank(productPage.getInput()), "name", productPage.getInput());

        IPage<ProductEntity> pageList = productService.page(page, queryWrapper);
//        pageList.getRecords()
//                .forEach(f->{
//                    // 查询产品明细
//                    QueryWrapper<productServiceItemEntity> query = new QueryWrapper<>();
//                    query.eq("productService_id", f.getproductServiceId())
//                        .orderByAsc("sort");
//                    f.setItems(productServiceItemService.list(query));
//                });
        page.setTotal(pageList.getTotal());
        log.info("产品列表result: {}", pageList.getRecords());
        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("产品列表查询")
    public R list(@RequestBody ProductEntity product){
        log.info("产品列表param: {}", product);
        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(product);
        return R.ok().put("data", productService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("产品详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        ProductEntity product = productService.getById(tenantId);

        return R.ok().put("material", product);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("产品保存")
    public R save(@RequestBody ProductForm product){
        log.info("产品保存param: {}", product);
        ProductEntity ProductEntity = new ProductEntity();
        BeanUtils.copyProperties(product, ProductEntity);
        Boolean saved = productService.save(ProductEntity);
        if(saved){
//            QueryWrapper<ProductEntity> query = new QueryWrapper<ProductEntity>()
//                    .eq("tenant_id", ProductEntity.getTenantId())
//                    .eq("code", ProductEntity.getCode());
//            ProductEntity ProductEntity1 = productService.getOne(query);
//            log.info("产品保存result: ");
//            log.info("产品保存result: {}", ProductEntity1);
//
////            List<productServiceItemEntity>  productServiceItemEntities = new ArrayList<>();
////            for(productServiceItemForm item : productService.getItems()){
////                item.setTenantId(ProductEntity.getTenantId());
////                item.setproductServiceId(ProductEntity1.getproductServiceId());
////                productServiceItemEntity productServiceItemEntity = new productServiceItemEntity();
////                BeanUtils.copyProperties(item, productServiceItemEntity);
////                productServiceItemEntities.add(productServiceItemEntity);
////            }
////            log.info("产品明细保存param: {}", productServiceItemEntities);
////            productServiceItemService.saveOrUpdateBatch(productServiceItemEntities);
//
            return R.ok();
        }
        return R.error();

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("产品修改")
    public R update(@RequestBody ProductForm product){
        log.info("产品修改param: {}", product);
        ProductEntity ProductEntity = new ProductEntity();
        BeanUtils.copyProperties(product, ProductEntity);
        productService.updateById(ProductEntity);

        // 先删除对应的productServiceItem
//        QueryWrapper<productServiceItemEntity> query = new QueryWrapper<productServiceItemEntity>()
//                .eq("tenant_id", ProductEntity.getTenantId())
//                .eq("productService_id", ProductEntity.getproductServiceId())
//                .notIn("productService_item_id", Arrays.stream(productService.getItems()).map(productServiceItemForm::getproductServiceItemId).collect(Collectors.toList()));
//        productServiceItemService.remove(query);

//        List<productServiceItemEntity>  productServiceItemEntities = new ArrayList<>();
//        for(productServiceItemForm item : productService.getItems()){
//            item.setTenantId(ProductEntity.getTenantId());
//            item.setproductServiceId(ProductEntity.getproductServiceId());
//            productServiceItemEntity productServiceItemEntity = new productServiceItemEntity();
//            BeanUtils.copyProperties(item, productServiceItemEntity);
//            productServiceItemEntities.add(productServiceItemEntity);
//        }
//        productServiceItemService.saveOrUpdateBatch(productServiceItemEntities);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("产品批量删除")
    public R delete(@RequestBody Long[] productServiceIds) {
        // 先删除对应的productServiceItem
        return productService.removeByIds(Arrays.asList(productServiceIds)) ?
                R.ok() : R.error();
    }


}
