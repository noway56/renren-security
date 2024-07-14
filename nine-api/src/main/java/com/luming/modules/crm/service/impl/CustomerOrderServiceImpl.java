package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerOrderDao;
import com.luming.modules.crm.entity.CustomerOrderEntity;
import com.luming.modules.crm.service.CustomerOrderService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerOrderService")
public class CustomerOrderServiceImpl extends ServiceImpl<CustomerOrderDao, CustomerOrderEntity> implements CustomerOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
