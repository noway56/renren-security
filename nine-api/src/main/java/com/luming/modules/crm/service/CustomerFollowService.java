package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.CustomerFollowEntity;

import java.util.Map;

/**
 * 客户沟通记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface CustomerFollowService extends IService<CustomerFollowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

