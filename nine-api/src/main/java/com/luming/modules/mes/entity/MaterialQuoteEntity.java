package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 原材料报价
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_material_quote")
public class MaterialQuoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	@TableId
	private Long tenantId;
	/**
	 * 原材料ID
	 */
	private Long materialId;
	/**
	 * 原材料税前价格
	 */
	private Integer rawPrice;
	/**
	 * 原材料含税价格
	 */
	private Integer taxPrice;
	/**
	 * 运费
	 */
	private Integer freight;
	/**
	 * 询价时间
	 */
	private Date startDate;

}
