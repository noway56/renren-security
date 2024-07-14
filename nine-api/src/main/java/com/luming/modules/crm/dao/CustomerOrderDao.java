package com.luming.modules.crm.dao;

import com.luming.modules.crm.entity.CustomerOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 销售订单
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Mapper
public interface CustomerOrderDao extends BaseMapper<CustomerOrderEntity> {
	
}
