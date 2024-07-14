package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckTemplateItemDao;
import com.luming.modules.lis.entity.CheckTemplateItemEntity;
import com.luming.modules.lis.service.CheckTemplateItemService;


@Service("checkTemplateItemService")
public class CheckTemplateItemServiceImpl extends ServiceImpl<CheckTemplateItemDao, CheckTemplateItemEntity> implements CheckTemplateItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
