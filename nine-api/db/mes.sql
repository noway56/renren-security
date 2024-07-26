CREATE TABLE `mes_formula` (
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `formula_id` bigint(20) NOT NULL COMMENT '配方ID',
  `code` varchar(50) NOT NULL COMMENT '配方编码',
  `purpose` varchar(200) DEFAULT NULL COMMENT '配方目的',
  `formula_type` int(11) DEFAULT NULL COMMENT '配方类型: 0. 参考配方(外部录入)，1. 试算配方(临时), 2. 试验配方， 3.储备配方(实验验证，未投产) 4. 不成熟生产配方<200吨无客诉, 5. 稳定配方<400吨无客诉， 6. 成熟配方>1000吨 无客诉',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `ash_percent` varchar(20) DEFAULT NULL COMMENT '灰分',
  `plastic_percent` varchar(20) DEFAULT NULL COMMENT '含胶量',
  `material_cost` int(11) DEFAULT NULL COMMENT '物料成本',
  `tax_cost` int(11) DEFAULT NULL COMMENT '含税成本',
  `tax_free_cost` int(11) DEFAULT NULL COMMENT '不含税成本',
  `suggested_price` int(11) DEFAULT NULL COMMENT '建议含税出厂售价',
  `suggested_tax_free_price` int(11) DEFAULT NULL COMMENT '建议不含税出厂售价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`formula_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品配方';


CREATE TABLE `mes_formula_item` (
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `formula_id` bigint(20) NOT NULL COMMENT '配方ID',
  `formula_item_id` bigint(20) NOT NULL COMMENT '配方子项ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_name` varchar(50) NOT NULL COMMENT '物料名称',
  `quantity` decimal(11,0) NOT NULL COMMENT '物料数量',
  `weight_ratio` int(11) NOT NULL COMMENT '物料重量比例（万分之X）',
  `tag_str` varchar(200) DEFAULT NULL COMMENT '物料标签，用,分割',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`formula_item_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品配方子项'

-- 生产配置字典
DROP TABLE IF EXISTS `mes_setting`;
CREATE TABLE `mes_cost_dict` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `setting_id` bigint NOT NULL COMMENT '设置ID',
  `setting_key` varchar(50) NOT NULL COMMENT '设置键',
  `setting_value` varchar(50) NOT NULL COMMENT '设置值',
  `unit` varchar(50) NOT NULL COMMENT '单位',
  `setting_desc` varchar(200) COMMENT '配置描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产配置字典';


-- 生产单
DROP TABLE IF EXISTS `mes_order`;
CREATE TABLE `mes_order` (
  `order_id` bigint NOT NULL COMMENT '生产单ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `order_no` varchar(50) NOT NULL COMMENT '生产单号',
  `order_type` varchar(50) NOT NULL COMMENT '生产单类型',
  `order_status` varchar(50) NOT NULL COMMENT '生产单状态',
  `product_id` bigint NOT NULL COMMENT '产品ID',
  `product_code` varchar(50) NOT NULL COMMENT '产品编码',
  `product_name` varchar(50) NOT NULL COMMENT '产品名称',
  `plan_qty` decimal(18,4) NOT NULL COMMENT '计划数量',
  `actual_qty` decimal(18,4) NOT NULL COMMENT '实际数量',
  `plan_start_time` datetime NOT NULL COMMENT '计划开始时间',
  `plan_end_time` datetime NOT NULL COMMENT '计划结束时间',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际开始时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '实际结束时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产单';


-- 配料单
DROP TABLE IF EXISTS `mes_bom`;
CREATE TABLE `mes_bom` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `mes_order_id` bigint NOT NULL COMMENT '生产单ID',
  `bom_no` varchar(50) NOT NULL COMMENT 'BOM编号',
  `bom_type` varchar(50) NOT NULL COMMENT 'BOM类型',
  `bom_status` varchar(50) NOT NULL COMMENT 'BOM状态',
  `operator_id` bigint NOT NULL COMMENT '操作人ID',
  `operator_name` varchar(50) NOT NULL COMMENT '操作人姓名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `mes_order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配料单';

--- 配料单明细
DROP TABLE IF EXISTS `mes_bom_detail`;
CREATE TABLE `mes_bom_detail`(
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `mes_order_id` bigint NOT NULL COMMENT '生产单ID',
  `bom_no` varchar(50) NOT NULL COMMENT 'BOM编号',
  `material_id` bigint NOT NULL COMMENT '物料ID',
  `wh_record_id` bigint NOT NULL COMMENT '入库记录ID',
  `material_name` varchar(50) NOT NULL COMMENT '物料名称',
  `material_type` varchar(50) NOT NULL COMMENT '物料类型',
  `material_unit` varchar(50) NOT NULL COMMENT '物料单位',
  `plan_qty` decimal(10,2) NOT NULL COMMENT '计划数量',
  `actual_qty` decimal(10,2) NOT NULL COMMENT '实际数量',
  `operator_id` bigint NOT NULL COMMENT '操作人ID',
  `operator_name` varchar(50) NOT NULL COMMENT '操作人姓名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `mes_order_id`, `bom_no`, `material_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配料单明细';

-- 生产记录
DROP TABLE IF EXISTS `mes_record`;
CREATE TABLE `mes_record` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `record_id` bigint NOT NULL COMMENT '生产记录ID',
  `mes_order_id` bigint NOT NULL COMMENT '生产单ID',
  `product_id` bigint NOT NULL COMMENT '产品ID',
  `product_name` varchar(50) NOT NULL COMMENT '产品名称',
  `work_group_id` bigint NOT NULL COMMENT '班组ID',
  `head_name`  varchar(50) NOT NULL COMMENT '组长姓名',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `status` tinyint NOT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `record_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产记录';

-- 生产工序
DROP TABLE IF EXISTS `mes_process`;
CREATE TABLE `mes_process` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `process_id` bigint NOT NULL COMMENT '工序ID',
  `process_name` varchar(50) NOT NULL COMMENT '工序名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产工序';

-- 生产工序参数模板
DROP TABLE IF EXISTS `mes_process_parameter_template`;
CREATE TABLE `mes_process_parameter_template` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `template_id` bigint NOT NULL COMMENT '模板ID',
  `process_id` bigint NOT NULL COMMENT '工序ID',
  `parameter_name` varchar(50) NOT NULL COMMENT '参数名称',
  `parameter_type` varchar(50) NOT NULL COMMENT '参数类型',
  `prameter_unit` varchar(50) NOT NULL COMMENT '参数单位',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产工序参数模板';


-- 生产记录明细
DROP TABLE IF EXISTS `mes_record_detail`;
CREATE TABLE `mes_record_detail` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `record_id` bigint NOT NULL COMMENT '生产记录ID',
  `mes_order_id` bigint NOT NULL COMMENT '生产单ID',
  `op_process_id` bigint NOT NULL COMMENT '工序ID',
  `op_process_template_id` bigint NOT NULL COMMENT '工序参数模板ID',
  `op_process_code` varchar(50) NOT NULL COMMENT '工序编码',
  `op_process_name` varchar(50) NOT NULL COMMENT '工序名称',
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产记录明细';

-- 生产记录参数
DROP TABLE IF EXISTS `mes_record_parameter`;
CREATE TABLE `mes_record_parameter` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `record_id` bigint NOT NULL COMMENT '生产记录ID',
  `op_process_template_id` bigint NOT NULL COMMENT '工序参数模板ID',
  `parameter_name` varchar(50) NOT NULL COMMENT '参数名称',
  `parameter_value` varchar(50) NOT NULL COMMENT '参数值',
  `parameter_unit` varchar(50) NOT NULL COMMENT '参数单位',
  `is_required` TINYINT DEFAULT 0 COMMENT '是否必填',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产记录参数';


