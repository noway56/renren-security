-- 供应商
drop table if exists `crm_provider`;
CREATE TABLE `crm_provider` (
	`tenant_id` BIGINT  NOT NULL COMMENT '租户ID',
	`company_id` BIGINT NOT NULL COMMENT '对应的公司ID',
	`business_owner_company` BIGINT NOT NULL COMMENT '业务归属-对应的公司',
	`business_owner_person` BIGINT COMMENT '业务归属-对应的人员',
	`provider_id` BIGINT NOT NULL COMMENT '供应商ID',
	`provider_type` VARCHAR(255) NOT NULL COMMENT '供应商类型',
	`product_type` VARCHAR(255) NOT NULL COMMENT '产品类型',
	`name` VARCHAR(255) NOT NULL COMMENT '供应商名称',
	`provider_code` VARCHAR(255) NOT NULL COMMENT '供应商编码',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`,`provider_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '供应商';

-- 供应商联系人
drop table if exists `crm_provider_contact`;
CREATE TABLE `crm_provider_contact`(
    `tenant_id` BIGINT NOT NULL COMMENT '租户ID',
    `provider_id` BIGINT  COMMENT '供应商ID',
    `contact_id` BIGINT NOT NULL COMMENT '联系人ID',
    `name` VARCHAR ( 50 ) NOT NULL COMMENT '联系人姓名',
    `mobile` VARCHAR ( 20 ) NOT NULL COMMENT '联系人手机号',
    `email` VARCHAR ( 50 ) COMMENT '联系人邮箱',
    `position` VARCHAR ( 50 ) COMMENT '联系人职位',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY ( `tenant_id`, `provider_id`, `contact_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '供应商联系人';

-- 客户
drop table if exists `crm_customer`;
CREATE TABLE `crm_customer`(
	`tenant_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`company_id` BIGINT NOT NULL COMMENT '对应的公司ID',
	`owner_company` BIGINT COMMENT '业务所属公司',
	`owner_user` BIGINT COMMENT '业务所属用户',
--	`code` VARCHAR ( 50 ) NOT NULL COMMENT '客户编码',
--	`name` VARCHAR ( 50 ) NOT NULL COMMENT '客户名称',
	`customer_needs` VARCHAR ( 50 ) COMMENT '客户需求',
	`stage` VARCHAR ( 50 ) COMMENT '客户阶段',
	`major_product` VARCHAR ( 50 ) COMMENT '主要产品',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `customer_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '客户管理';

-- 客户送货地址
drop table if exists `crm_customer_deliever_address`;
CREATE TABLE `crm_customer_deliever_address`(
	`tenant_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`province` VARCHAR ( 50 ) NOT NULL COMMENT '省',
	`city` VARCHAR ( 50 ) NOT NULL COMMENT '市',
	`area` VARCHAR ( 50 ) NOT NULL COMMENT '区',
	`address` VARCHAR ( 100 ) NOT NULL COMMENT '详细地址',
	`contact_name` VARCHAR ( 50 ) NOT NULL COMMENT '联系人姓名',
	`contact_mobile` VARCHAR ( 50 ) NOT NULL COMMENT '联系人手机号',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `customer_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '客户送货地址管理';

-- 客户联系人
drop table if exists `crm_customer_contact`;
CREATE TABLE `crm_customer_contact` (
	`tenant_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`contact_id` BIGINT NOT NULL,
	`position` VARCHAR ( 20 ) NOT NULL COMMENT '职位',
	`name` VARCHAR ( 50 ) NOT NULL COMMENT '联系人姓名',
	`mobile` VARCHAR ( 20 ) NOT NULL COMMENT '手机号',
	`email` VARCHAR ( 50 ) COMMENT '邮箱',
	`remark` VARCHAR ( 200 ) COMMENT '备注',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `contact_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '客户联系人';

-- 客户协议价
drop table if exists `crm_provider_quote`;
CREATE TABLE `crm_provider_quote`(
    `tenant_id` BIGINT NOT NULL COMMENT '租户ID',
    `customer_id` BIGINT  COMMENT '客户ID',
    `customer_name` VARCHAR(255) NOT NULL COMMENT '客户名称'
    `company_id` BIGINT NOT NULL COMMENT '销售公司ID',
    `company_name` VARCHAR(255) NOT NULL COMMENT '销售公司名称',
    `quote_id` BIGINT NOT NULL COMMENT '报价ID',
    `product_id` BIGINT NOT NULL COMMENT '产品ID',
    `product_name` VARCHAR ( 50 ) NOT NULL COMMENT '产品名称',
    `product_code` VARCHAR ( 50 ) NOT NULL COMMENT '产品编码',
    `price` integer NOT NULL COMMENT '产品价格',
    `include_tax` TINYINT NOT NULL COMMENT '是否含税',
    `include_freight` TINYINT NOT NULL COMMENT '是否含运费',
    `pay_period` VARCHAR ( 50 ) NOT NULL COMMENT '付款周期',
    `delivery_type` INT NOT NULL COMMENT '提货方式，1.物流+送货上门， 2.自提， 3.物流+提货点自提',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商报价';

-- 客户跟进记录
drop table if exists `crm_customer_follow`;
CREATE TABLE `crm_customer_follow` (
	`tenant_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`follow_id` BIGINT NOT NULL,
	`stage` VARCHAR ( 20 ) NOT NULL COMMENT '客户所处阶段',
	`content` VARCHAR ( 500 ) NOT NULL COMMENT '沟通内容',
	`plan` VARCHAR ( 200 ) NOT NULL COMMENT '后续计划',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间'
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '客户沟通记录';

-- 销售订单
drop table if exists `crm_customer_order`;
CREATE TABLE `crm_customer_order` (
	`tenant_id` BIGINT NOT NULL,
	`order_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`order_no` VARCHAR(50) NOT NULL COMMENT '订单编号',
	`third_order_no` VARCHAR(50) COMMENT '第三方订单号',
	`contract_no` VARCHAR(50) COMMENT '合同编号',
	`countract_record` VARCHAR ( 200 ) COMMENT '合同保存地址',
	`order_status` TINYINT NOT NULL COMMENT '订单状态,1:下单，2:生产, 3:已发货， 4: 已收货， 5: 已开票， 6:已收款，7：已退货处理',
	`tax_include` TINYINT DEFAULT 1 COMMENT '订单报价含税类型, 1: 含税, 2:不含税 ',
	`freight_include` TINYINT DEFAULT 1 COMMENT '订单报价含运费类型, 1: 含运费, 2:不含运费',
	`payment_type` TINYINT DEFAULT 1 COMMENT '订单支付类型, 1: 现结, 2: 预付, 3: 月结',
	`sell_amount` TINYINT DEFAULT 1 COMMENT '订单销售金额',
	`transport_type` TINYINT DEFAULT 1 COMMENT '订单运输类型, 1: 厂家货运, 2: 自提, 3:厂家货运+物流 4: 厂家货运+自提物流部分 5 第三方长途货运',
	`transport_unit_fee` INTEGER COMMENT '订单运输费用单价',
	`freight_amount` INTEGER COMMENT '订单运输费用总价——厂家需要支付的费用',
	`final_amount` INTEGER NOT NULL COMMENT '订单最终收费金额',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `order_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '销售订单';

-- 销售订单明细
drop table if exists `crm_customer_order_item`;
CREATE TABLE `crm_customer_order_item` (
	`tenant_id` BIGINT NOT NULL,
	`order_item_id` BIGINT NOT NULL,
	`order_id` BIGINT NOT NULL,
	`product_id` BIGINT NOT NULL,
	`product_name` VARCHAR ( 50 ) NOT NULL COMMENT '产品名称',
	`product_spec` VARCHAR ( 50 ) NOT NULL COMMENT '产品规格',
	`product_unit` VARCHAR ( 50 ) NOT NULL COMMENT '产品单位',
	`product_count` INTEGER NOT NULL COMMENT '产品数量',
	`product_price` INTEGER NOT NULL COMMENT '产品单价',
	`product_amount` INTEGER NOT NULL COMMENT '产品金额',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `order_id`, `order_item_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '销售订单明细';

-- 销售入账记录
drop table if exists `crm_customer_order_pay_record`;
CREATE TABLE `crm_customer_account_record` (
	`tenant_id` BIGINT NOT NULL,
	`record_id` BIGINT NOT NULL,
	`customer_id` BIGINT NOT NULL,
	`record_type` INTEGER NOT NULL COMMENT '入账类型, 1: 销售订单',
	`method` INTEGER NOT NULL COMMENT '入账方式',
	`record_time` datetime NOT NULL COMMENT '入账时间',
	`record_desc` VARCHAR ( 200 ) NOT NULL COMMENT '入账描述',
	`record_amount` INTEGER NOT NULL COMMENT '入账金额',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	`order_id` BIGINT DEFAULT NULL COMMENT '关联销售订单',
	PRIMARY KEY ( `tenant_id`, `record_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '销售入账记录';


-- 采购订单
drop table if exists `crm_supplier_order`;
CREATE TABLE `crm_supplier_order`(
   `tenant_id` BIGINT NOT NULL,
	`order_id` BIGINT NOT NULL,
	`provider_id` BIGINT NOT NULL,
	`third_order_no` VARCHAR ( 50 ) COMMENT '第三方订单号',
	`contract_no` VARCHAR ( 50 ) COMMENT '合同编号',
	`countract_record` VARCHAR ( 200 ) COMMENT '合同保存地址',
	`tax_include` TINYINT DEFAULT 1 COMMENT '订单报价含税类型, 1: 含税, 2:不含税 ',
	`freight_include` TINYINT DEFAULT 1 COMMENT '订单报价含运费类型, 1: 含运费, 2:不含运费',
	`payment_type` TINYINT DEFAULT 1 COMMENT '订单支付类型, 1: 现结, 2: 预付, 3: 月结',
	`final_amount` TINYINT DEFAULT 1 COMMENT '订单最终金额',
	`transport_type` TINYINT DEFAULT 1 COMMENT '订单运输类型, 1: 厂家货运, 2: 自提, 3:厂家货运+物流 4: 厂家货运+自提物流部分 5 第三方长途货运',
	`transport_unit_fee` INTEGER COMMENT '订单运输费用单价',
	`freight_fee` INTEGER COMMENT '订单运费总费用-订单外需要额外支付的',
	`order_status` INTEGER NOT NULL COMMENT '订单状态',
	`order_time` datetime NOT NULL COMMENT '订单时间',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `order_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '采购订单';


-- 采购订单明细
drop table if exists `crm_supplier_order_detail`;
CREATE TABLE `crm_supplier_order_detail`(
  `tenant_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `product_name` VARCHAR ( 50 ) NOT NULL COMMENT '产品名称',
  `product_spec` VARCHAR ( 50 ) NOT NULL COMMENT '产品规格',
  `product_unit` VARCHAR ( 50 ) NOT NULL COMMENT '产品单位',
  `product_count` INTEGER NOT NULL COMMENT '产品数量',
  `product_price` INTEGER NOT NULL COMMENT '产品单价',
  `product_amount` INTEGER NOT NULL COMMENT '产品总价',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY ( `tenant_id`, `order_id`, `product_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '采购订单明细';

-- 采购支付记录
drop table if exists `crm_customer_account_pay`;
CREATE TABLE `crm_customer_account_pay` (
	`tenant_id` BIGINT NOT NULL,
	`pay_id` BIGINT NOT NULL,
	`provider_id` BIGINT NOT NULL,
	`pay_type` INTEGER NOT NULL COMMENT '出账类型',
	`method` INTEGER NOT NULL COMMENT '出账方式：xxx公司xxx账户',
	`pay_time` datetime NOT NULL COMMENT '出账时间',
	`pay_desc` VARCHAR ( 200 ) NOT NULL COMMENT '出账描述',
	`pay_amount` INTEGER NOT NULL COMMENT '出账金额',
	`order_id` BIGINT NOT NULL COMMENT '采购订单ID',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_deleted` TINYINT DEFAULT 0 COMMENT '是否已删除',
	`delete_time` datetime DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY ( `tenant_id`, `pay_id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '出账记录';

