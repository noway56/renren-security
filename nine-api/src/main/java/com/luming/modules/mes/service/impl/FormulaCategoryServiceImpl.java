package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.FormulaCategoryDao;
import com.luming.modules.mes.entity.FormulaCategoryEntity;
import com.luming.modules.mes.service.FormulaCategoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author luwu
 */
@Service("formulaCategoryService")
public class FormulaCategoryServiceImpl extends ServiceImpl<FormulaCategoryDao, FormulaCategoryEntity> implements FormulaCategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
