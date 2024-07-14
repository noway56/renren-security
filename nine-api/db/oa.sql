-- 公司
DROP TABLE IF EXISTS `oa_company`;
CREATE TABLE `oa_company`(
  `tenant_id` bigint COMMENT '租户ID',
  `company_id` bigint NOT NULL COMMENT '公司id',
  `name` varchar(50) COMMENT '公司名称',
  `code` varchar(50) COMMENT '公司编码',
  `intro` varchar(200) COMMENT '公司简介',
--  `company_type` int COMMENT '公司类型-0：本体公司，1：供应商，2：客户， 3双重身份',
  `is_internal` tinyint COMMENT '是否为本体公司',
  `is_supplier` tinyint COMMENT '是否为供应商',
  `is_customer` tinyint COMMENT '是否为客户',
  `boss_name` varchar(50) COMMENT '公司法人',
  `boss_phone` varchar(50) COMMENT '公司法人电话',
  `boss_email` varchar(50) COMMENT '公司法人邮箱',
  `province` varchar(50) COMMENT '公司所在省份',
  `city` varchar(50) COMMENT '公司所在城市',
  `area` varchar(50) COMMENT '公司所在地区',
  `address` varchar(100) COMMENT '公司详细地址',
  `remark` varchar(200) COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `company_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司表';

-- 公司的发票信息
DROP TABLE IF EXISTS `oa_invoice_info`;
CREATE TABLE `oa_invoice_info`(
  `tenant_id` bigint COMMENT '租户ID',
  `company_id` bigint COMMENT '公司id',
  `id` bigint NOT NULL COMMENT '发票信息id',
  `title` varchar(50) COMMENT '发票抬头',
  `tax_number` varchar(50) COMMENT '纳税人识别号',
  `address` varchar(100) COMMENT '地址',
  `phone` varchar(50) COMMENT '电话',
  `bank` varchar(50) COMMENT '开户行',
  `bank_account` varchar(50) COMMENT '银行账户',
  `remark` varchar(200) COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT 0 COMMENT '是否已删除',
  `delete_time` datetime COMMENT '删除时间',
  PRIMARY KEY (`tenant_id`, `company_id`, `id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司的发票信息表';

-- 公司账户
drop table if exists `crm_account`;
CREATE TABLE `crm_customer_account` (
	`tenant_id` BIGINT NOT NULL,
	`company_id` BIGINT NOT NULL,
	`account_balance` INTEGER NOT NULL COMMENT '账户余额(总)',
	`customer_balance` INTEGER NOT NULL COMMENT '客户账户余额(应收)',
	`provider_balance` INTEGER NOT NULL COMMENT '供应商账户余额(应付)',
	`account_freeze` INTEGER DEFAULT 0 COMMENT '账户冻结金额',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `customer_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '公司账户';

-- 公司账户流水
drop table if exists `crm_account_flow`;
CREATE TABLE `crm_customer_account_flow` (
	`tenant_id` BIGINT NOT NULL,
	`internal_company_id` BIGINT NOT NULL,
	`company_id` BIGINT NOT NULL,
	`company_name` VARCHAR ( 100 ) NOT NULL COMMENT '公司名称',
	`provider_id` BIGINT NOT NULL COMMENT '供应商ID',
	`customer_id` BIGINT NOT NULL COMMENT '客户ID',
	`account_flow_id` BIGINT NOT NULL,
  `account_flow_type` VARCHAR(10) NOT NULL COMMENT '流水类型',
	`account_flow_amount` INTEGER NOT NULL COMMENT '流水金额',
	`account_flow_remark` VARCHAR ( 200 ) NOT NULL COMMENT '流水备注',
	`account_flow_time` datetime NOT NULL COMMENT '流水时间',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `customer_id`, `account_flow_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '公司账户流水';

-- 部门
DROP TABLE IF EXISTS `oa_dept`;
CREATE TABLE `oa_dept` (
  `tenant_id` bigint COMMENT '租户ID',
  `company_id` bigint COMMENT '公司id',
  `dept_id` bigint NOT NULL COMMENT '部门id',
  `parent_id` bigint COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) COMMENT '部门名称',
  `order_num` int COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL COMMENT '逻辑删除  1：已删除  0：正常',
  `delete_time` datetime COMMENT '删除时间',
  `is_active` tinyint(1) NOT NULL COMMENT '是否可用  1：不可用  0：正常',
  PRIMARY KEY (`tenant_id`, `company_id`, `dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- 用户
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `tenant_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `default_account_id` bigint default null COMMENT '默认账户id',
  `email` varchar(100) COMMENT '邮箱',
  `mobile` varchar(100) COMMENT '手机号',
  `status` tinyint COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) COMMENT '部门ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL COMMENT '逻辑删除  1：已删除  0：正常',
  `delete_time` datetime COMMENT '删除时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- 角色
DROP TABLE IF EXISTS `oa_role`;
CREATE TABLE `oa_role` (
`tenant_id` bigint COMMENT '租户ID',
  `role_id` bigint NOT NULL,
  `role_name` varchar(100) COMMENT '角色名称',
  `role_code` varchar(100) COMMENT '角色编码',
  `remark` varchar(100) COMMENT '备注',
  `dept_id` bigint(20) COMMENT '部门ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL COMMENT '逻辑删除  1：已删除  0：正常',
  `delete_time` datetime COMMENT '删除时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- 用户与角色对应关系
DROP TABLE IF EXISTS `oa_user_role`;
CREATE TABLE `oa_user_role` (
  `id` bigint NOT NULL,
  `user_id` bigint COMMENT '用户ID',
  `role_id` bigint COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- 角色与菜单对应关系
DROP TABLE IF EXISTS `oa_role_menu`;
CREATE TABLE `oa_role_menu` (
  `id` bigint NOT NULL,
  `role_id` bigint COMMENT '角色ID',
  `menu_id` bigint COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- 角色与部门对应关系
DROP TABLE IF EXISTS `oa_role_dept`;
CREATE TABLE `oa_role_dept` (
  `id` bigint NOT NULL,
  `role_id` bigint COMMENT '角色ID',
  `dept_id` bigint COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';