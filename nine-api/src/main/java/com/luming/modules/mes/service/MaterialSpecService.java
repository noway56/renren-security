package com.luming.modules.mes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.entity.MaterialSpecEntity;

import java.util.Map;

/**
 * 原材料规格
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface MaterialSpecService extends IService<MaterialSpecEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

