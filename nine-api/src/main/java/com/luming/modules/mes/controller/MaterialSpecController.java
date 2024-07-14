package com.luming.modules.mes.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialSpecEntity;
import com.luming.modules.mes.service.MaterialSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 原材料规格
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/materialspec")
public class MaterialSpecController {
    @Autowired
    private MaterialSpecService materialSpecService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialSpecService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        MaterialSpecEntity materialSpec = materialSpecService.getById(tenantId);

        return R.ok().put("materialSpec", materialSpec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialSpecEntity materialSpec){
        materialSpecService.save(materialSpec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialSpecEntity materialSpec){
        ValidatorUtils.validateEntity(materialSpec);
        materialSpecService.updateById(materialSpec);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        materialSpecService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
