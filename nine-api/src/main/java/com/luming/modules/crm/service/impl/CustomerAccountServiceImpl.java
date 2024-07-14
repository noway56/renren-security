package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerAccountDao;
import com.luming.modules.crm.entity.CustomerAccountEntity;
import com.luming.modules.crm.service.CustomerAccountService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerAccountService")
public class CustomerAccountServiceImpl extends ServiceImpl<CustomerAccountDao, CustomerAccountEntity> implements CustomerAccountService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
