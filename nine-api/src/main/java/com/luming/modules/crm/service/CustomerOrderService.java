package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.CustomerOrderEntity;

import java.util.Map;

/**
 * 销售订单
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface CustomerOrderService extends IService<CustomerOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

