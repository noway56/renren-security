package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerDelieverAddressDao;
import com.luming.modules.crm.entity.CustomerDelieverAddressEntity;
import com.luming.modules.crm.service.CustomerDelieverAddressService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerDelieverAddressService")
public class CustomerDelieverAddressServiceImpl extends ServiceImpl<CustomerDelieverAddressDao, CustomerDelieverAddressEntity> implements CustomerDelieverAddressService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
