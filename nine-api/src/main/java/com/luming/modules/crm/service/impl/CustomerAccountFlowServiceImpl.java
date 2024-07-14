package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerAccountFlowDao;
import com.luming.modules.crm.entity.CustomerAccountFlowEntity;
import com.luming.modules.crm.service.CustomerAccountFlowService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerAccountFlowService")
public class CustomerAccountFlowServiceImpl extends ServiceImpl<CustomerAccountFlowDao, CustomerAccountFlowEntity> implements CustomerAccountFlowService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
