package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.MaterialSpecDao;
import com.luming.modules.mes.entity.MaterialSpecEntity;
import com.luming.modules.mes.service.MaterialSpecService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialSpecService")
public class MaterialSpecServiceImpl extends ServiceImpl<MaterialSpecDao, MaterialSpecEntity> implements MaterialSpecService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
