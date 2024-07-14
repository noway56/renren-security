package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckItemDao;
import com.luming.modules.lis.entity.CheckItemEntity;
import com.luming.modules.lis.service.CheckItemService;


@Service("checkItemService")
public class CheckItemServiceImpl extends ServiceImpl<CheckItemDao, CheckItemEntity> implements CheckItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
