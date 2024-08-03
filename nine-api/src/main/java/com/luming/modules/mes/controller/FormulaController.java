package com.luming.modules.mes.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.FormulaEntity;
import com.luming.modules.mes.entity.FormulaItemEntity;
import com.luming.modules.mes.form.FormulaForm;
import com.luming.modules.mes.form.FormulaItemForm;
import com.luming.modules.mes.form.FormulaPageForm;
import com.luming.modules.mes.service.FormulaItemService;
import com.luming.modules.mes.service.FormulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 配方
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/formula")
@Api(tags = "配方")
@Slf4j
public class FormulaController {
    @Autowired
    private FormulaService formulaService;

    @Autowired
    private FormulaItemService formulaItemService;

    /**
     * 配方分页
     */
    @PostMapping("/page")
    @ApiOperation("配方分页查询")
    public R page(@RequestBody FormulaPageForm formulaPage){
        log.info("配方列表param: {}", formulaPage);
        ValidatorUtils.validateEntity(formulaPage);

        Page<FormulaEntity> page = new Page<>();
        page.setCurrent(formulaPage.getPage());
        page.setSize(formulaPage.getPageSize());

        QueryWrapper<FormulaEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", formulaPage.getTenantId())
                    .eq(StringUtils.isNotBlank(formulaPage.getCategoryName()),"category_name", formulaPage.getCategoryName())
                            .in(!formulaPage.getFormulaType().isEmpty(),"formula_type", formulaPage.getFormulaType());
        queryWrapper.like(StringUtils.isNotBlank(formulaPage.getInput()), "name", formulaPage.getInput());

        IPage<FormulaEntity> pageList = formulaService.page(page, queryWrapper);
        pageList.getRecords()
                .forEach(f->{
                    // 查询配方明细
                    QueryWrapper<FormulaItemEntity> query = new QueryWrapper<>();
                    query.eq("formula_id", f.getFormulaId())
                        .orderByAsc("sort");
                    f.setItems(formulaItemService.list(query));
                });
        page.setTotal(pageList.getTotal());
        log.info("配方列表result: {}", pageList.getRecords());
        return R.ok().put("data", pageList);
    }

    /**
     * 原材料列表
     */
    @PostMapping("/list")
    @ApiOperation("配方列表查询")
    public R list(@RequestBody FormulaEntity formula){
        log.info("配方列表param: {}", formula);
        QueryWrapper<FormulaEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(formula);
        return R.ok().put("data", formulaService.list(queryWrapper));
    }



    /**
     * 信息
     */
    @PostMapping("/info/{tenantId}")
    @ApiOperation("配方详情")
    public R info(@PathVariable("tenantId") Long tenantId){
        FormulaEntity formula = formulaService.getById(tenantId);

        return R.ok().put("material", formula);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("配方保存")
    public R save(@RequestBody FormulaForm formula){
        log.info("配方保存param: {}", formula);
        FormulaEntity formulaEntity = new FormulaEntity();
        BeanUtils.copyProperties(formula, formulaEntity);
        Boolean saved = formulaService.save(formulaEntity);
        if(saved){
            QueryWrapper<FormulaEntity> query = new QueryWrapper<FormulaEntity>()
                    .eq("tenant_id", formulaEntity.getTenantId())
                    .eq("code", formulaEntity.getCode());
            FormulaEntity formulaEntity1 = formulaService.getOne(query);
            log.info("配方保存result: ");
            log.info("配方保存result: {}", formulaEntity1);

            List<FormulaItemEntity>  formulaItemEntities = new ArrayList<>();
            for(FormulaItemForm item : formula.getItems()){
                item.setTenantId(formulaEntity.getTenantId());
                item.setFormulaId(formulaEntity1.getFormulaId());
                FormulaItemEntity formulaItemEntity = new FormulaItemEntity();
                BeanUtils.copyProperties(item, formulaItemEntity);
                formulaItemEntities.add(formulaItemEntity);
            }
            log.info("配方明细保存param: {}", formulaItemEntities);
            formulaItemService.saveOrUpdateBatch(formulaItemEntities);

            return R.ok();
        }
        return R.error();

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("配方修改")
    public R update(@RequestBody FormulaForm formula){
        log.info("配方修改param: {}", formula);
        FormulaEntity formulaEntity = new FormulaEntity();
        BeanUtils.copyProperties(formula, formulaEntity);
        formulaService.updateById(formulaEntity);

        // 先删除对应的formulaItem
        QueryWrapper<FormulaItemEntity> query = new QueryWrapper<FormulaItemEntity>()
                .eq("tenant_id", formulaEntity.getTenantId())
                .eq("formula_id", formulaEntity.getFormulaId())
                .notIn("formula_item_id", Arrays.stream(formula.getItems()).map(FormulaItemForm::getFormulaItemId).collect(Collectors.toList()));
        formulaItemService.remove(query);

        List<FormulaItemEntity>  formulaItemEntities = new ArrayList<>();
        for(FormulaItemForm item : formula.getItems()){
            item.setTenantId(formulaEntity.getTenantId());
            item.setFormulaId(formulaEntity.getFormulaId());
            FormulaItemEntity formulaItemEntity = new FormulaItemEntity();
            BeanUtils.copyProperties(item, formulaItemEntity);
            formulaItemEntities.add(formulaItemEntity);
        }
        formulaItemService.saveOrUpdateBatch(formulaItemEntities);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("配方批量删除")
    public R delete(@RequestBody Long[] formulaIds) {
        // 先删除对应的formulaItem
        return formulaService.removeByIds(Arrays.asList(formulaIds)) ?
                R.ok() : R.error();
    }


}
