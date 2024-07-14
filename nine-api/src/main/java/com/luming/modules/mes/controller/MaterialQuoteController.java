package com.luming.modules.mes.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.common.validator.ValidatorUtils;
import com.luming.modules.mes.entity.MaterialQuoteEntity;
import com.luming.modules.mes.service.MaterialQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 原材料报价
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("mes/materialquote")
public class MaterialQuoteController {
    @Autowired
    private MaterialQuoteService materialQuoteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialQuoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        MaterialQuoteEntity materialQuote = materialQuoteService.getById(tenantId);

        return R.ok().put("materialQuote", materialQuote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialQuoteEntity materialQuote){
        materialQuoteService.save(materialQuote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialQuoteEntity materialQuote){
        ValidatorUtils.validateEntity(materialQuote);
        materialQuoteService.updateById(materialQuote);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        materialQuoteService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
