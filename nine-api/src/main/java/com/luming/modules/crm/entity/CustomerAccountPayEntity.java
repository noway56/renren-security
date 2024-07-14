package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 出账记录
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_customer_account_pay")
public class CustomerAccountPayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 
	 */
	private Long payId;
	/**
	 * 
	 */
	private Long providerId;
	/**
	 * 出账类型
	 */
	private Integer payType;
	/**
	 * 出账方式
	 */
	private Integer method;
	/**
	 * 出账时间
	 */
	private Date payTime;
	/**
	 * 出账描述
	 */
	private String payDesc;
	/**
	 * 出账金额
	 */
	private Integer payAmount;
	/**
	 * 采购订单ID
	 */
	private Long orderId;
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
