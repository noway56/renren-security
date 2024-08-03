package com.luming.modules.crm.entity;

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
@TableName("crm_product_category")
public class ProductCategoryEntity implements Serializable {
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
	 * 备注
	 */
	private String  remark;

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
