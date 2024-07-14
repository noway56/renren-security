/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.modules.oa.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 添加公司表单
 *
 * @author luwu
 *  @email luwu2015@foxmail.com
 *   @date 2024-03-15 17:22:19
 */
@Data
@ApiModel(value = "公司分页查询表单")
public class CompanyPageForm {
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
