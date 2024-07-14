package com.luming.modules.mes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.mes.entity.MaterialQuoteEntity;

import java.util.Map;

/**
 * 原材料报价
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface MaterialQuoteService extends IService<MaterialQuoteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

