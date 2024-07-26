package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.mes.dao.FormulaItemDao;
import com.luming.modules.mes.entity.FormulaItemEntity;
import com.luming.modules.mes.service.FormulaItemService;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.mes.service.impl.RecipeItemServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 22:41
 */
@Service("formulaItemService")
public class FormulaItemServiceImpl extends ServiceImpl<FormulaItemDao, FormulaItemEntity> implements FormulaItemService {
}
