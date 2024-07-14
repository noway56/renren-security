package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购订单
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_supplier_order")
public class SupplierOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 
	 */
	private Long orderId;
	/**
	 * 
	 */
	private Long providerId;
	/**
	 * 第三方订单号
	 */
	private String thirdOrderNo;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 合同保存地址
	 */
	private String countractRecord;
	/**
	 * 订单报价含税类型, 1: 含税, 2:不含税 
	 */
	private Integer taxInclude;
	/**
	 * 订单报价含运费类型, 1: 含运费, 2:不含运费
	 */
	private Integer freightInclude;
	/**
	 * 订单支付类型, 1: 现结, 2: 预付, 3: 月结
	 */
	private Integer paymentType;
	/**
	 * 订单最终金额
	 */
	private Integer finalAmount;
	/**
	 * 订单运输类型, 1: 厂家货运, 2: 自提, 3:厂家货运+物流 4: 厂家货运+自提物流部分 5 第三方长途货运
	 */
	private Integer transportType;
	/**
	 * 订单运输费用单价
	 */
	private Integer transportUnitFee;
	/**
	 * 订单运费总费用-订单外需要额外支付的
	 */
	private Integer freightFee;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 订单时间
	 */
	private Date orderTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否已删除
	 */
	private Integer isDeleted;
	/**
	 * 删除时间
	 */
	private Date deleteTime;

}
