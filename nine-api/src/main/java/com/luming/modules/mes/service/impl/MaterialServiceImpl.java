package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.dao.MaterialDao;
import com.luming.modules.mes.entity.MaterialEntity;
import com.luming.modules.mes.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {



}
