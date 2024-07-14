package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckRecordDao;
import com.luming.modules.lis.entity.CheckRecordEntity;
import com.luming.modules.lis.service.CheckRecordService;


@Service("checkRecordService")
public class CheckRecordServiceImpl extends ServiceImpl<CheckRecordDao, CheckRecordEntity> implements CheckRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
