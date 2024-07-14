package com.luming.modules.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luming.modules.oa.dao.DeptDao;
import com.luming.modules.oa.entity.DeptEntity;
import com.luming.modules.oa.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Class: com.luming.modules.oa.service.impl.DeptServiceImpl
 * @Desc:
 * @author: luwu
 * @Date: 2024-03-18 23:13
 */
@Service("deptService")
@Slf4j
public class DeptServiceImpl extends ServiceImpl<DeptDao, DeptEntity> implements DeptService {
}
