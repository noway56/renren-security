package com.luming.modules.mes.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialCategorySpecEntity;
import com.luming.modules.mes.service.MaterialCategorySpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 原材料规格规则
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/materialcategoryspec")
public class MaterialCategorySpecController {
    @Autowired
    private MaterialCategorySpecService materialCategorySpecService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialCategorySpecService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        MaterialCategorySpecEntity materialCategorySpec = materialCategorySpecService.getById(tenantId);

        return R.ok().put("materialCategorySpec", materialCategorySpec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialCategorySpecEntity materialCategorySpec){
        materialCategorySpecService.save(materialCategorySpec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialCategorySpecEntity materialCategorySpec){
        ValidatorUtils.validateEntity(materialCategorySpec);
        materialCategorySpecService.updateById(materialCategorySpec);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        materialCategorySpecService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
