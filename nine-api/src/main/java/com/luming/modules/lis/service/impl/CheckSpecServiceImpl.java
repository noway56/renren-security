package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckSpecDao;
import com.luming.modules.lis.entity.CheckSpecEntity;
import com.luming.modules.lis.service.CheckSpecService;


@Service("checkSpecService")
public class CheckSpecServiceImpl extends ServiceImpl<CheckSpecDao, CheckSpecEntity> implements CheckSpecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
