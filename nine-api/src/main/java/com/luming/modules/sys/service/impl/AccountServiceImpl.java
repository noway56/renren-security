/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.exception.RRException;
import com.luming.common.validator.Assert;
import com.luming.modules.sys.dao.AccountDao;
import com.luming.modules.sys.entity.TokenEntity;
import com.luming.modules.sys.entity.AccountEntity;
import com.luming.modules.sys.service.TokenService;
import com.luming.modules.sys.service.AccountService;
import com.luming.modules.sys.form.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("accountService")
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements AccountService {
	@Autowired
	private TokenService tokenService;

	@Override
	public AccountEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<AccountEntity>().eq("mobile", mobile));
	}

	@Override
	public Map<String, Object> login(LoginForm form) {
		AccountEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(form.getTenant(), user.getUserId());
		log.info("token:{}", tokenEntity.toString());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}

}
