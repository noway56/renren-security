-- 物料料类别
DROP TABLE IF EXISTS `wh_material_category`;
CREATE TABLE `mes_material_category` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `category_id` bigint NOT NULL COMMENT '原材料类别ID',
  `category_level` int(11) NOT NULL COMMENT '材料分裂级别',
  `parent` bigint NOT NULL COMMENT '上级分类，默认为0级',
  `category_code` varchar(50) NOT NULL COMMENT '原材料类别编码',
  `category_name` varchar(50) NOT NULL COMMENT '原材料类别',
  `category_type` varchar(50) COMMENT '原材料类别类型, 碳酸钙，聚丙烯，聚乙烯，铝酸脂偶联剂等等',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料类别';

-- 原材料规格模板
DROP TABLE IF EXISTS `wh_material_category_spec`;
CREATE TABLE `mes_material_category_spec` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `spec_id` bigint NOT NULL COMMENT '原材料规格ID',
  `category_id` bigint NOT NULL COMMENT '原材料类别',
  `spec_code` varchar(50) NOT NULL COMMENT '原材料规格编码',
  `spec_name` varchar(50) NOT NULL COMMENT '原材料规格名称',
  `spec_unit` varchar(50) NOT NULL COMMENT '原材料规格单位',
  `spec_desc` varchar(200) COMMENT '原材料规格描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`spec_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料规格定义';

-- 原材料检测项目模板
DROP TABLE IF EXISTS `wh_material_category_check_item`;
CREATE TABLE `mse_material_category_check_item`(
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `check_tempalte_id` bigint NOT NULL COMMENT '检测项目模板ID',
  `category_id` bigint NOT NULL COMMENT '原材料类别',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `category_id`, `item_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料检测项目模板定义';


-- 原材料——一个类别的材料+供应商=具体的材料
DROP TABLE IF EXISTS `wh_material`;
CREATE TABLE `mes_material` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `material_id` bigint NOT NULL COMMENT '原材料ID',
  `material_code` varchar(50) NOT NULL COMMENT '原材料编码',
  `provider_id` bigint NOT NULL COMMENT '供应商ID',
  `category_id` bigint NOT NULL COMMENT '原材料类别ID',
  `category_name` varchar(50) COMMENT '原材料类别名称',
  `material_name` varchar(50) NOT NULL COMMENT '原材料名称',
  `latest_price` int NOT NULL COMMENT '原材料价格，以分为单位',
  `unit_price` varchar(100) NOT NULL COMMENT '计价单位，可能为吨，千克等',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`material_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料';

-- 原材料规格的具体值
DROP TABLE IF EXISTS `wh_material_spec`;
CREATE TABLE `mes_material_spec` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `spec_id` bigint NOT NULL COMMENT '原材料规格ID',
  `material_id` bigint NOT NULL COMMENT '原材料ID',
  `spec_code` varchar(50) NOT NULL COMMENT '原材料规格编码',
  `spec_name` varchar(50) NOT NULL COMMENT '原材料规格名称',
  `spec_value` varchar(50) NOT NULL COMMENT '原材料规格值',
  `upper_bound` varchar(50) NOT NULL COMMENT '规格最大值',
  `lower_bound` varchar(50) NOT NULL COMMENT '规格最小值',
  `spec_unit` varchar(50) NOT NULL COMMENT '原材料规格单位',
  `spec_desc` varchar(200) COMMENT '原材料规格描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',,
  PRIMARY KEY (`spec_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料规格';

-- 原材料报价
drop table if exists `crm_material_quote`;
CREATE TABLE `crm_material_quote`(
  `tenant_id` BIGINT NOT NULL COMMENT '租户ID',
	`material_id` BIGINT NOT NULL COMMENT '原材料ID',
	`price` integer NOT NULL COMMENT '产品价格',
	`include_tax` TINYINT NOT NULL COMMENT '是否含税',
  `include_freight` TINYINT NOT NULL COMMENT '是否含运费',
  `delivery_type` INT NOT NULL COMMENT '提货方式，1.物流+送货上门， 2.自提， 3.物流+提货点自提',
	`freight` INT NOT NULL COMMENT '运费',
	`pay_period` INT NOT NULL COMMENT '付款周期',
	`start_date` datetime NOT NULL COMMENT '询价时间',
	PRIMARY KEY ( `tenant_id`, `material_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '原材料报价';

-- 材料入库记录
DROP TABLE IF EXISTS `mes_material_warehousing_record`;
CREATE TABLE `mes_material_warehousing_record` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `wh_record_id` bigint NOT NULL COMMENT '入库记录ID',
  `material_id` bigint NOT NULL COMMENT '物料ID',
  `material_name` varchar(50) NOT NULL COMMENT '物料名称',
  `material_amount` varchar(50) NOT NULL COMMENT '物料数量',
  `material_unit` varchar(50) NOT NULL COMMENT '物料单位',
  `warehouse_label`  varchar(50) NOT NULL COMMENT '仓库标号',
  `position_label`  varchar(50) NOT NULL COMMENT '仓位标号',
  `record_person` varchar(50) NOT NULL COMMENT '记录人',
  `wh_time` datetime NOT NULL COMMENT '入库时间',
  `remark` varchar(200) COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='材料入库记录';

-- 材料入库检测
DROP TABLE IF EXISTS `mes_material_warehousing_check`;
CREATE TABLE `mes_material_warehousing_check` (
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `record_id` bigint NOT NULL COMMENT '检测记录ID',
  `wh_record_id` bigint NOT NULL COMMENT '入库记录ID',
  `material_id` bigint NOT NULL COMMENT '物料ID',
  `material_name` varchar(50) NOT NULL COMMENT '物料名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `check_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='材料入库检测';


-- 产品
DROP TABLE IF EXISTS `wh_product`;
CREATE TABLE `mes_product`(
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `product_id` bigint NOT NULL COMMENT '产品ID',
  `product_code` varchar(50) NOT NULL COMMENT '产品编码',
  `product_name` varchar(50) NOT NULL COMMENT '产品名称',
  `product_desc` varchar(200) COMMENT '产品描述',
  `product_type` varchar(50) NOT NULL COMMENT '产品类型, 1:原材料加工，2：成品代理',
  `raw_price` integer NOT NULL COMMENT '建议不含税价',
  `tax_price` integer NOT NULL COMMENT '建议含税售价',
  `factory_raw_price` integer NOT NULL COMMENT '出厂价-不含税',
  `factory_price` integer NOT NULL COMMENT '出厂价-含税',
  `stock` integer NOT NULL COMMENT '库存',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`product_id`)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品';

-- 产品规格
DROP TABLE IF EXISTS `mes_product_spec`;
CREATE TABLE `mes_product_spec`(
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `product_spec_id` bigint NOT NULL COMMENT '产品规格ID',
  `product_id` bigint NOT NULL COMMENT '产品ID',
  `spec_code` varchar(50) NOT NULL COMMENT '规格编码',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `spec_desc` varchar(200) COMMENT '规格描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品规格';


