package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 配方
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date
 */
@Data
@TableName("crm_recipe")
public class RecipeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 配方ID
	 */
	@TableId
	private Long recipeId;
	/**
	 * 配方编码
	 */
	private String code;
	/**
	 * 配方目的
	 */
	private String purpose;
	/**
	 * 灰分
	 */
	private String ashPercent;
	/**
	 * 含胶量
	 */
	private String plasticPercent;
	/**
	 * 原料成本，以分为单位
	 */
	private Integer materialCost;
	/**
	 * 含税成本，以分为单位
	 */
	private Integer taxCost;
	/**
	 * 非税成本，以分为单位
	 */
	private Integer TaxFreeCost;
	/**
	 * 建议含税出厂价，以分为单位
	 */
	private Integer suggestedPrice;
	/**
	 * 建议无税出厂价，以分为单位
	 */
	private Integer suggestedTaxFreePrice;
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
