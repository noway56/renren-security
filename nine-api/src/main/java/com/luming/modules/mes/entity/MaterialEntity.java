package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 原材料
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_material")
public class MaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 原材料ID
	 */
	@TableId
	private Long materialId;
	/**
	 * 原材料编码
	 */
	private String materialCode;
	/**
	 * 原材料名称
	 */
	private String materialName;
	/**
	 * 供应商ID
	 */
	private Long providerId;
	/**
	 * 供应商名
	 */
	private String providerName;
	/**
	 * 供应商编码
	 */
	private String providerCode;
	/**
	 * 原材料类别ID
	 */
	private Long categoryId;
	/**
	 * 原材料类别名称
	 */
	private String categoryName;
	private String tagStr;
	private String deliverMethod;
	/**
	 * 原材料价格，以分为单位
	 */
	private Integer rawPrice;
	/**
	 * 原材料含税价格，以分为单位
	 */
	private Integer taxPrice;
	/**
	 * 原材料运费，以分为单位
	 */
	private Integer freightPrice;
	/**
	 * 原材料最终成本，以分为单位
	 */
	private Integer finalCost;

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
