package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerAccountPayDao;
import com.luming.modules.crm.entity.CustomerAccountPayEntity;
import com.luming.modules.crm.service.CustomerAccountPayService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerAccountPayService")
public class CustomerAccountPayServiceImpl extends ServiceImpl<CustomerAccountPayDao, CustomerAccountPayEntity> implements CustomerAccountPayService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
