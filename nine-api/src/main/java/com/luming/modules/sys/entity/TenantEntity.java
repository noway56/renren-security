package com.luming.modules.sys.entity;

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
 * @date 2024-03-16 12:30:50
 */
@Data
@TableName("tb_tenant")
public class TenantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 组织名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
