package com.luming.modules.mes.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Class: com.luming.modules.mes.form.MaterialCategoryForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-12 02:04
 */
@Data
@ApiModel("物料类别表单")
public class MaterialCategoryForm {

    @ApiModelProperty(value = "租户ID")
    @NotNull(message="租户ID不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "物料类别ID")
    private Long categoryId;

    @ApiModelProperty(value = "物料类别编码")
    private String code;

    @ApiModelProperty(value = "物料类别")
    private String name;

    @ApiModelProperty(value = "分类级别")
    private Integer level;

    @ApiModelProperty(value = "父级ID")
    @NotNull(message="父级ID不能为空")
    private Long parentId;

    @ApiModelProperty(value = "物料类别分类,1.原材料(可用于生产,自用), 2.代理销售")
    private Integer usageType;



}
