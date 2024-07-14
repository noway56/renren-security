package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.CustomerFollowDao;
import com.luming.modules.crm.entity.CustomerFollowEntity;
import com.luming.modules.crm.service.CustomerFollowService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerFollowService")
public class CustomerFollowServiceImpl extends ServiceImpl<CustomerFollowDao, CustomerFollowEntity> implements CustomerFollowService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
