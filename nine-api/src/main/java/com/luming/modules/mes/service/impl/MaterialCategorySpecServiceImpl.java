package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.MaterialCategorySpecDao;
import com.luming.modules.mes.entity.MaterialCategorySpecEntity;
import com.luming.modules.mes.service.MaterialCategorySpecService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialCategorySpecService")
public class MaterialCategorySpecServiceImpl extends ServiceImpl<MaterialCategorySpecDao, MaterialCategorySpecEntity> implements MaterialCategorySpecService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
