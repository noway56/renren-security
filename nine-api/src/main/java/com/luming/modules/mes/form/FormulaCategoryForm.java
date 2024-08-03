package com.luming.modules.mes.form;

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
@ApiModel("配方类别表单")
public class FormulaCategoryForm {

    @ApiModelProperty(value = "租户ID")
    @NotNull(message="租户ID不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "配方类别ID")
    private Long categoryId;

    @ApiModelProperty(value = "配方类别编码")
    private String code;

    @ApiModelProperty(value = "配方类别")
    private String name;

    @ApiModelProperty(value = "分类级别")
    private Integer level;

    @ApiModelProperty(value = "父级ID")
    @NotNull(message="父级ID不能为空")
    private Long parentId;

    @ApiModelProperty(value = "备注")
    private String remark;


}
