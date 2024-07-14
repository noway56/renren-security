package com.luming.modules.lis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;

import com.luming.modules.lis.dao.CheckDetailDao;
import com.luming.modules.lis.entity.CheckDetailEntity;
import com.luming.modules.lis.service.CheckDetailService;


@Service("checkDetailService")
public class CheckDetailServiceImpl extends ServiceImpl<CheckDetailDao, CheckDetailEntity> implements CheckDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

}
