package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 配方
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date
 */
@Data
@TableName("mes_formula")
public class FormulaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 配方ID
	 */
	@TableId
	private Long formulaId;
	/**
	 * 配方编码
	 */
	private String code;
	/**
	 * 配方目的
	 */
	private String purpose;
	/**
	 *  配方类型:
	 *  0. 参考配方(外部录入)，
	 *  1. 试算配方(临时),
	 *  2. 试验配方，
	 *  3. 储备配方(实验已验证，未投产)
	 *  4. 不成熟生产配方<200吨验证,
	 *  5. 稳定配方<400吨验证，
	 *  6. 成熟配方 >1000吨验证',
	 */
	private Integer formulaType;
	/**
	 * 生产是否启用
	 */
	private Integer enabled;
	/**
	 * 灰分
	 */
	private Integer ashPercent;
	/**
	 * 含胶量
	 */
	private Integer plasticPercent;
	/**
	 * 单位原料损耗
	 */
	private Integer materialLoss;
	/**
	 *  单位电耗
	 */
	private Integer electricCost;
	/**
	 * 单位人工工资
	 */
	private  Integer labourCost;
	/**
	 * 包装费用
	 */
	private  Integer packageCost;
	/**
	 * 总重量
	 */
	private Integer totalWeight;
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

	@TableField(exist = false)
	private List<FormulaItemEntity> items;
	/**
	 *  备注
	 */
	private String remark;
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
