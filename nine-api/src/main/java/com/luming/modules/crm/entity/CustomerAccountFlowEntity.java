package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户账户流水
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_customer_account_flow")
public class CustomerAccountFlowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 
	 */
	private Long customerId;
	/**
	 * 
	 */
	private Long accountFlowId;
	/**
	 * 流水类型
	 */
	private String accountFlowType;
	/**
	 * 流水金额
	 */
	private Integer accountFlowAmount;
	/**
	 * 流水备注
	 */
	private String accountFlowRemark;
	/**
	 * 流水时间
	 */
	private Date accountFlowTime;
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
