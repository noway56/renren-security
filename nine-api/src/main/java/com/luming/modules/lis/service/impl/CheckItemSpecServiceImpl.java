package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckItemSpecDao;
import com.luming.modules.lis.entity.CheckItemSpecEntity;
import com.luming.modules.lis.service.CheckItemSpecService;


@Service("checkItemSpecService")
public class CheckItemSpecServiceImpl extends ServiceImpl<CheckItemSpecDao, CheckItemSpecEntity> implements CheckItemSpecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
