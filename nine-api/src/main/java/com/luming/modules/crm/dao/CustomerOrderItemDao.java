package com.luming.modules.crm.dao;

import com.luming.modules.crm.entity.CustomerOrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 销售订单明细
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Mapper
public interface CustomerOrderItemDao extends BaseMapper<CustomerOrderItemEntity> {
	
}
