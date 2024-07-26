package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.mes.dao.MesSettingDao;
import com.luming.modules.mes.entity.MesSettingEntity;
import com.luming.modules.mes.service.MesSettingService;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.mes.service.impl.MesSettingServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-25 21:56
 */
@Service("mesSettingService")
public class MesSettingServiceImpl extends ServiceImpl<MesSettingDao, MesSettingEntity> implements MesSettingService {
}
