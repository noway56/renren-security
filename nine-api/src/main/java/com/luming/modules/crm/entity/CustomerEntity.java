package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户管理
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *租户
	 */
	private Long tenantId;
	/**
	 *客户id
	 */
	@TableId
	private Long customerId;
	/**
	 * 对应的公司ID
	 */
	private Long companyId;
	/**
	 * 业务所属公司
	 */
	private Long businessOwnerId;
	/**
	 * 业务所属公司名字
	 */
	private String businessOwnerName;
	/**
	 * 业务所属用户
	 */
	private Long businessOwnerUserId;
	/**
	 * 业务所属用户名字
	 */
	private String businessOwnerUserName;
	/**
	 * 客户编码
	 */
	private String code;
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 客户需求
	 */
	private String customerNeeds;
	/**
	 * 客户阶段
	 */
	private String customerCommunicationStage;
	/**
	 * 客户核心产品
	 */
	private String coreProduct;
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
