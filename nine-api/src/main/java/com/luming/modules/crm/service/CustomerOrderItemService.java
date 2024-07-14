package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.CustomerOrderItemEntity;

import java.util.Map;

/**
 * 销售订单明细
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface CustomerOrderItemService extends IService<CustomerOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

