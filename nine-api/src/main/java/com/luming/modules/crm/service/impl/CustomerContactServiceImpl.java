package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerContactDao;
import com.luming.modules.crm.entity.CustomerContactEntity;
import com.luming.modules.crm.service.CustomerContactService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerContactService")
public class CustomerContactServiceImpl extends ServiceImpl<CustomerContactDao, CustomerContactEntity> implements CustomerContactService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
