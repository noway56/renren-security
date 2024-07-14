package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerDao;
import com.luming.modules.crm.entity.CustomerEntity;
import com.luming.modules.crm.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
