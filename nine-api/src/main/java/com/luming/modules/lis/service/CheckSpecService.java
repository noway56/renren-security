package com.luming.modules.lis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.lis.entity.CheckSpecEntity;

import java.util.Map;

/**
 * 检测指标
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
public interface CheckSpecService extends IService<CheckSpecEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

