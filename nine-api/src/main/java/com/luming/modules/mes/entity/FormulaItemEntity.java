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
@TableName("mes_formula_item")
public class FormulaItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 配方子项ID
	 */
	@TableId
	private Long formulaItemId;
	/**
	 * 配方id
	 */
	private Long formulaId;
	/**
	 * 原材料id
	 */
	private Long materialId;
	/**
	 * 原材料名称
	 */
	private String materialName;
	/**
	 * 原材料用量(g)
	 */
	private Integer quantity;
	/**
	 * 原材料重量比例（万分之X）
	 */
	private Integer weightRatio;
	/**
	 * 单价
	 */
	private Integer price;
	/**
	 * 总价
	 */
	private Integer totalPrice;
	private Integer sort;
	/**
	 * 标签
	 */
	private String tagStr;
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
