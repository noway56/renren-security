package com.luming.modules.mes.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Class: com.luming.modules.crm.form.MaterialCategoryPageForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-11 23:03
 */
@Data
@ApiModel("物料分类分页查询")
public class MaterialCategoryPageForm {
    @ApiModelProperty(value = "当前页数")
    @NotNull(message="当前页数不能为空")
    private Long page;

    @ApiModelProperty(value = "页面大小")
    @NotNull(message="页面大小不能为空")
    private Long pageSize;

    @ApiModelProperty(value = "租户ID")
    @NotNull(message="租户ID不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "搜索关键字")
    private String input;
}
