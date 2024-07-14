package com.luming.modules.lis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.lis.entity.CheckItemSpecEntity;

import java.util.Map;

/**
 * 检测项目指标
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
public interface CheckItemSpecService extends IService<CheckItemSpecEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

