-- 检测项目
DROP TABLE IF EXISTS `mes_check_item`;
CREATE TABLE `mes_check_item` (
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `item_name` varchar(255) NOT NULL COMMENT '检测项目名称',
  `item_name_en` varchar(255) NOT NULL COMMENT '检测项目英文名',
  `remark` varchar(50) NOT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`,`item_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检测项目定义';


-- 检测指标
DROP TABLE IF EXISTS `mes_check_spec`;
CREATE TABLE `mes_check_spec`(
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `spec_id` bigint NOT NULL COMMENT '检测指标ID',
  `spec_name` varchar(255) NOT NULL COMMENT '检测指标名称',
  `spec_name_en` varchar(255) NOT NULL COMMENT '检测指标英文名',
  `spec_standard` varchar(255) NOT NULL COMMENT '检测指标标准',
  `spec_unit` varchar(50) NOT NULL COMMENT '指标结果单位',
  `remark` varchar(50) NOT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `spec_id`),
  unique index (`tenant_id`, `spec_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='检测指标';


-- 检测项目指标
DROP TABLE IF EXISTS `mes_check_item_spec`;
CREATE TABLE `mes_check_item_spec`(
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `item_id` bigint NOT NULL COMMENT '检测项目ID',
  `spec_id` bigint NOT NULL COMMENT '检测指标ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `item_id`, `spec_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检测项目指标';


-- 检查模板
DROP TABLE IF EXISTS `mes_check_template`;
CREATE TABLE `mes_check_template`(
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `template_id` bigint NOT NULL COMMENT '模板id',
  `template_name` varchar(50) NOT NULL COMMENT '模板名称',
  `intro` varchar(50) NOT NULL COMMENT '模板描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `template_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检查模板';


-- 检查模板明细
DROP TABLE IF EXISTS `mes_check_template_item`;
CREATE TABLE `mes_check_template_item`(
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `template_id` bigint NOT NULL COMMENT '模板id',
  `item_id` bigint NOT NULL COMMENT '检测项目ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `template_id`, `item_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检查模板明细';


-- 检测记录
DROP TABLE IF EXISTS `mes_check_record`;
CREATE TABLE `mes_check_record` (
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `record_id` bigint NOT NULL COMMENT '检测记录id',
  `record_time` datetime NOT NULL COMMENT '检测时间',
  `record_person` bigint NOT NULL COMMENT '检测人',
  `record_status` tinyint NOT NULL COMMENT '检测状态',
  `template_id` bigint NOT NULL COMMENT '模板id',
  `result` varchar(50) NOT NULL COMMENT '检测结果',
  `remark` varchar(200) COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `record_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检测记录';


-- 检测详情
DROP TABLE IF EXISTS `mes_check_detail`;
CREATE TABLE `mes_check_detail` (
  `tenant_id` bigint NOT NULL COMMENT '租户id',
  `record_id` bigint NOT NULL COMMENT '检测记录id',
  `item_id` bigint NOT NULL COMMENT '检测项目id',
  `spec_id` bigint NOT NULL COMMENT '检测指标id',
  `spec_name` varchar(50) NOT NULL COMMENT '检测指标名称',
  `raw_data` varchar(200) NOT NULL COMMENT '原始数据，一般为多次测量具体值，采用json方式存储',
  `spec_value` varchar(50) NOT NULL COMMENT '检测指标值',
  `spec_unit` varchar(10) NOT NULL COMMENT '检测指标单位',
  `spec_result` tinyint NOT NULL COMMENT '检测指标结果',
  `spec_remark` varchar(200) COMMENT '检测指标备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  primary key (`tenant_id`, `record_id`, `item_id`, `spec_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检测详情';

