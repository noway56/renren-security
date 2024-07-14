package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 入账记录
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_customer_account_record")
public class CustomerAccountRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 
	 */
	private Long recordId;
	/**
	 * 
	 */
	private Long customerId;
	/**
	 * 入账类型, 1: 销售订单
	 */
	private Integer recordType;
	/**
	 * 入账方式
	 */
	private Integer method;
	/**
	 * 入账时间
	 */
	private Date recordTime;
	/**
	 * 入账描述
	 */
	private String recordDesc;
	/**
	 * 入账金额
	 */
	private Integer recordAmount;
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
	/**
	 * 关联销售订单
	 */
	private Long orderId;

}
