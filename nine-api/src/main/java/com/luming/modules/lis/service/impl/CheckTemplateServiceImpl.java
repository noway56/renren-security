package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckTemplateDao;
import com.luming.modules.lis.entity.CheckTemplateEntity;
import com.luming.modules.lis.service.CheckTemplateService;


@Service("checkTemplateService")
public class CheckTemplateServiceImpl extends ServiceImpl<CheckTemplateDao, CheckTemplateEntity> implements CheckTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
