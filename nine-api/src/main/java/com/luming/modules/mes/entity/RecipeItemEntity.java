package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 配方子项
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_material_item")
public class RecipeItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 配方子项ID
	 */
	@TableId
	private Long recipeItemId;
	/**
	 * 配方id
	 */
	private Long receipId;
	/**
	 * 原材料id
	 */
	private Long materialId;
	/**
	 * 原材料名称
	 */
	private String materialName;
	/**
	 * 原材料用量(kg)
	 */
	private Double quantity;
	/**
	 * 原材料重量比例
	 */
	private Double weightRatio;
	/**
	 * 标签
	 */
	private String tag;
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
