package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.CustomerAccountPayEntity;

import java.util.Map;

/**
 * 出账记录
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface CustomerAccountPayService extends IService<CustomerAccountPayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

