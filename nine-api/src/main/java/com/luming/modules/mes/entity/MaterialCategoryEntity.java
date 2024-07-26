package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 原材料类别
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_material_category")
public class MaterialCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 原材料类别ID
	 */
	@TableId
	private Long categoryId;
	/**
	 * 原材料类别编码
	 */
	private String code;
	/**
	 * 原材料类别
	 */
	private String name;
	/**
	 * 分类级别
	 */
	private Integer level;
	/**
	 * 父级ID
	 */
	private Long parentId;
	/**
	 * 原材料类别分类,1.原材料(可用于生产,自用), 2.代理销售
	 */
	private Integer usageType;
	/**
	 * 标签
	 */
	private String tags;

	@TableField(exist = false)
	private String level1;

	@TableField(exist = false)
	private String level2;

	@TableField(exist = false)
	private String level3;
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
