package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商联系人
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_provider_contact")
public class ProviderContactEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	@TableId
	private Long tenantId;
	/**
	 * 供应商ID
	 */
	private Long providerId;
	/**
	 * 联系人ID
	 */
	private Long contactId;
	/**
	 * 联系人姓名
	 */
	private String name;
	/**
	 * 联系人手机号
	 */
	private String mobile;
	/**
	 * 联系人邮箱
	 */
	private String email;
	/**
	 * 联系人职位
	 */
	private String position;
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
