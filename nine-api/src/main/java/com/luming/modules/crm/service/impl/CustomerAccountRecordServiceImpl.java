package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerAccountRecordDao;
import com.luming.modules.crm.entity.CustomerAccountRecordEntity;
import com.luming.modules.crm.service.CustomerAccountRecordService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerAccountRecordService")
public class CustomerAccountRecordServiceImpl extends ServiceImpl<CustomerAccountRecordDao, CustomerAccountRecordEntity> implements CustomerAccountRecordService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
