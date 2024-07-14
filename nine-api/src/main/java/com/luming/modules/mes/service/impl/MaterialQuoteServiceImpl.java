package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.MaterialQuoteDao;
import com.luming.modules.mes.entity.MaterialQuoteEntity;
import com.luming.modules.mes.service.MaterialQuoteService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialQuoteService")
public class MaterialQuoteServiceImpl extends ServiceImpl<MaterialQuoteDao, MaterialQuoteEntity> implements MaterialQuoteService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
