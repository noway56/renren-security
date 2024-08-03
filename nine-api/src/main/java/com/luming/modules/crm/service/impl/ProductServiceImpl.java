package com.luming.modules.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.common.utils.PageUtils;
import com.luming.modules.crm.dao.ProductCategoryDao;
import com.luming.modules.crm.dao.ProductDao;
import com.luming.modules.crm.entity.ProductCategoryEntity;
import com.luming.modules.crm.entity.ProductEntity;
import com.luming.modules.crm.service.ProductCategoryService;
import com.luming.modules.crm.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author luwu
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
