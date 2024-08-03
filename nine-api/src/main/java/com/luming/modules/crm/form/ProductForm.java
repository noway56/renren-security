package com.luming.modules.crm.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Class: com.luming.modules.mes.form.MaterialCategoryForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-12 02:04
 */
@Data
@ApiModel("产品表单")
public class ProductForm {

    @ApiModelProperty(value = "租户ID")
    @NotNull(message="租户ID不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "产品ID")
    private Long productId;

    @ApiModelProperty(value = "产品编码")
    private String code;

    @ApiModelProperty(value = "产品")
    private String name;

    @ApiModelProperty(value = "产品类型id")
    private Long categoryId;

    @ApiModelProperty(value = "产品类型名")
    private String categoryName;

    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 是否自产
     */
    @ApiModelProperty(value = "是否自产")
    private Integer isSelfMade;
    /**
     * 关联配方id
     */
    @ApiModelProperty(value = "关联配方id")
    private Long formulaId;
    /**
     * 关联配方编码
     */
    @ApiModelProperty(value = "关联配方编码")
    private String formulaCode;
    /**
     *   产品描述
     */
    @ApiModelProperty(value = "产品描述")
    private String description;
    /**
     * 不含税成本
     */
    @ApiModelProperty(value = "不含税成本")
    private Integer taxFreeCost;
    /**
     * 含税成本
     */
    @ApiModelProperty(value = "含税成本")
    private Integer cost;
    /**
     * 建议不含税出厂价
     */
    @ApiModelProperty(value = "建议不含税出厂价")
    private Integer  suggestTaxFreePrice;
    /**
     * 建议含税出厂价
     */
    @ApiModelProperty(value = "建议含税出厂价")
    private Integer suggestPrice;
    /**
     *  库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;
    /**
     *  单位
     */
    @ApiModelProperty(value = "单位")
    private String stockUnit;
}
