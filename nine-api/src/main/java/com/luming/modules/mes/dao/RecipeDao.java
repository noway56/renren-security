package com.luming.modules.mes.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luming.modules.mes.entity.RecipeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Interface: com.luming.modules.mes.dao.RecipeDao
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 22:29
 */
@Mapper
public interface RecipeDao extends BaseMapper<RecipeEntity> {
}
