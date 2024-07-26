package com.luming.modules.mes.form;

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
public class FormulaItemForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 配方子项ID
	 */
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
	 * 标签
	 */
	private String tagStr;

	private Integer price;

	private Integer  totalPrice;

	private Integer sort;

}
