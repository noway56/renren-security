package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.ProviderContactDao;
import com.luming.modules.crm.entity.ProviderContactEntity;
import com.luming.modules.crm.service.ProviderContactService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("providerContactService")
public class ProviderContactServiceImpl extends ServiceImpl<ProviderContactDao, ProviderContactEntity> implements ProviderContactService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
