package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.MaterialCategoryDao;
import com.luming.modules.mes.entity.MaterialCategoryEntity;
import com.luming.modules.mes.service.MaterialCategoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialCategoryService")
public class MaterialCategoryServiceImpl extends ServiceImpl<MaterialCategoryDao, MaterialCategoryEntity> implements MaterialCategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
