package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.mes.dao.RecipeItemDao;
import com.luming.modules.mes.entity.RecipeItemEntity;
import com.luming.modules.mes.service.RecipeItemService;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.mes.service.impl.RecipeItemServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 22:41
 */
@Service("recipeItemService")
public class RecipeItemServiceImpl extends ServiceImpl<RecipeItemDao, RecipeItemEntity> implements RecipeItemService {
}
