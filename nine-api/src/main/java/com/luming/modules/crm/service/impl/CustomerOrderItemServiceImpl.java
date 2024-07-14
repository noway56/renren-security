package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerOrderItemDao;
import com.luming.modules.crm.entity.CustomerOrderItemEntity;
import com.luming.modules.crm.service.CustomerOrderItemService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerOrderItemService")
public class CustomerOrderItemServiceImpl extends ServiceImpl<CustomerOrderItemDao, CustomerOrderItemEntity> implements CustomerOrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
