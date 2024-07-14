package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 原材料规格规则
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_material_category_spec")
public class MaterialCategorySpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	@TableId
	private Long tenantId;
	/**
	 * 原材料规格ID
	 */
	private Long specId;
	/**
	 * 原材料类别
	 */
	private Long categoryId;
	/**
	 * 原材料规格编码
	 */
	private String specCode;
	/**
	 * 原材料规格名称
	 */
	private String specName;
	/**
	 * 原材料规格单位
	 */
	private String specUnit;
	/**
	 * 原材料规格描述
	 */
	private String specDesc;
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
