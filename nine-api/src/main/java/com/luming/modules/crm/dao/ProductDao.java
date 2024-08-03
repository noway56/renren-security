package com.luming.modules.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luming.modules.crm.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 原材料类别
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
