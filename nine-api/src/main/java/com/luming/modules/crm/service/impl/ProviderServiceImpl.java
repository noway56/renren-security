package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.ProviderDao;
import com.luming.modules.crm.entity.ProviderEntity;
import com.luming.modules.crm.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("providerService")
public class ProviderServiceImpl extends ServiceImpl<ProviderDao, ProviderEntity> implements ProviderService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
