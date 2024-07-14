package com.luming.modules.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.oa.dao.CompanyDao;
import com.luming.modules.oa.entity.CompanyEntity;
import com.luming.modules.oa.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.service.impl.DeptServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-03-17 21:09
 */
@Service("companyService")
@Slf4j
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {
}
