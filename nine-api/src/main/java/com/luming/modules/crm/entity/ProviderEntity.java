package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_provider")
public class ProviderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 对应的公司ID
	 */
	private Long companyId;
	/**
	 * 供应商ID
	 */
	@TableId
	private Long providerId;
	/**
	 * 产品类型
	 */
	private String productType;
	/**
	 * 供应商名称
	 */
	private String name;
	/**
	 * 供应商编码
	 */
	private String code;
	/**
	 * 备注
	 */

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
