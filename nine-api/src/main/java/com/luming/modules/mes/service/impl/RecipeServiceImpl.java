package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.mes.dao.RecipeDao;
import com.luming.modules.mes.entity.RecipeEntity;
import com.luming.modules.mes.service.RecipeService;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.mes.service.impl.RecipeServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 22:40
 */
@Service("recipeService")
public class RecipeServiceImpl extends ServiceImpl<RecipeDao, RecipeEntity> implements RecipeService {
}
