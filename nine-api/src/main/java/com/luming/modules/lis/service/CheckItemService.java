package com.luming.modules.lis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.lis.entity.CheckItemEntity;

import java.util.Map;

/**
 * 检测项目定义
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
public interface CheckItemService extends IService<CheckItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

