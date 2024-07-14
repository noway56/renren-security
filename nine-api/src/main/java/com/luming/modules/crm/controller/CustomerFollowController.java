package com.luming.modules.crm.controller;

import com.luming.common.utils.PageUtils;
import com.luming.common.utils.R;
import com.luming.modules.crm.entity.CustomerFollowEntity;
import com.luming.modules.crm.service.CustomerFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 客户沟通记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@RestController
@RequestMapping("crm/customerfollow")
public class CustomerFollowController {
    @Autowired
    private CustomerFollowService customerFollowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerFollowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    public R info(@PathVariable("tenantId") Long tenantId){
        CustomerFollowEntity customerFollow = customerFollowService.getById(tenantId);

        return R.ok().put("customerFollow", customerFollow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerFollowEntity customerFollow){
        customerFollowService.save(customerFollow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerFollowEntity customerFollow){
        customerFollowService.updateById(customerFollow);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] tenantIds){
        customerFollowService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
