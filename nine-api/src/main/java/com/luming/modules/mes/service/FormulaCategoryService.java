package com.luming.modules.mes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.entity.FormulaCategoryEntity;

import java.util.Map;

/**
 * 原材料类别
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface FormulaCategoryService extends IService<FormulaCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

