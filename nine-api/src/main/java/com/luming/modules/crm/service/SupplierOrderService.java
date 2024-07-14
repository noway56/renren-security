package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.SupplierOrderEntity;

import java.util.Map;

/**
 * 采购订单
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface SupplierOrderService extends IService<SupplierOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

