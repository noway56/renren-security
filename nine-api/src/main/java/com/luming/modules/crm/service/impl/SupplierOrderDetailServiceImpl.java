package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.SupplierOrderDetailDao;
import com.luming.modules.crm.entity.SupplierOrderDetailEntity;
import com.luming.modules.crm.service.SupplierOrderDetailService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("supplierOrderDetailService")
public class SupplierOrderDetailServiceImpl extends ServiceImpl<SupplierOrderDetailDao, SupplierOrderDetailEntity> implements SupplierOrderDetailService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
