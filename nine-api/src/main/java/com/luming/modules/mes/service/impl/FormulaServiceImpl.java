package com.luming.modules.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.mes.dao.FormulaDao;
import com.luming.modules.mes.entity.FormulaEntity;
import com.luming.modules.mes.service.FormulaService;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.mes.service.impl.RecipeServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 22:40
 */
@Service("formulaService")
public class FormulaServiceImpl extends ServiceImpl<FormulaDao, FormulaEntity> implements FormulaService {
}
