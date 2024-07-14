package com.luming.modules.lis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.lis.entity.CheckTemplateEntity;

import java.util.Map;

/**
 * 检查模板
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
public interface CheckTemplateService extends IService<CheckTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

