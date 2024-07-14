package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.ProviderAccountFlowDao;
import com.luming.modules.crm.entity.ProviderAccountFlowEntity;
import com.luming.modules.crm.service.ProviderAccountFlowService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("providerAccountFlowService")
public class ProviderAccountFlowServiceImpl extends ServiceImpl<ProviderAccountFlowDao, ProviderAccountFlowEntity> implements ProviderAccountFlowService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
