/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luming.modules.sys.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface AccountDao extends BaseMapper<AccountEntity> {

}
