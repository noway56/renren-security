package com.luming.modules.oa.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Class: com.luming.modules.oa.form.CompanyQuery
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-14 02:00
 */
@Data
@ApiModel(value = "CompanyQuery", description = "公司查询")
public class CompanyQuery {

    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    @ApiModelProperty(value = "公司id")
    private String companyId;
}
