package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.SupplierOrderDao;
import com.luming.modules.crm.entity.SupplierOrderEntity;
import com.luming.modules.crm.service.SupplierOrderService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("supplierOrderService")
public class SupplierOrderServiceImpl extends ServiceImpl<SupplierOrderDao, SupplierOrderEntity> implements SupplierOrderService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
