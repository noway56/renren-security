package com.luming.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.entity.ProviderAccountEntity;

import java.util.Map;

/**
 * 供应商账户
 *
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
public interface ProviderAccountService extends IService<ProviderAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

