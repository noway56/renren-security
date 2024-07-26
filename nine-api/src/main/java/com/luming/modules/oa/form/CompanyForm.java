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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 添加公司表单
 *
 * @author luwu
 *  @email luwu2015@foxmail.com
 *   @date 2024-03-15 17:22:19
 */
@Data
@ApiModel(value = "CompanyForm", description = "添加公司表单")
public class CompanyForm {
    @ApiModelProperty(value = "租户id")
    @NotNull(message="租户id不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "公司名称")
    @NotBlank(message="公司名不能为空")
    private String name;

    @ApiModelProperty(value = "公司编码")
    private String code;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private  String phone;
    /**
     * 网址
     */
    @ApiModelProperty(value = "网址")
    private  String website;

    @ApiModelProperty(value = "公司简介")
    private String intro;

    @ApiModelProperty(value = "公司类型, 1: 一般， 2: 小微， 3：自然人(虚拟公司)")
    @NotNull(message="公司类型不能为空")
    private Integer companyType;

    @ApiModelProperty(value = "是否为客户, 0: 非客户， 1:客户")
    @NotNull(message="是否为客户不能为空")
    private Integer isCustomer;

    @ApiModelProperty(value = "是否为供应商, 0: 非供应商， 1:供应商")
    @NotNull(message="是否为供应商不能为空")
    private Integer isProvider;

    @ApiModelProperty(value = "是否为内部, 1: 内部， 0: 外部")
    @NotNull(message="是否为内部不能为空")
    private Integer isInternal;

    @ApiModelProperty(value = "老板姓名")
    private String bossName;

    @ApiModelProperty(value = "老板手机号")
    private String bossPhone;

    @ApiModelProperty(value = "老板邮箱")
    private String bossEmail;

    @ApiModelProperty(value = "所在省")
    private String province;

    @ApiModelProperty(value = "所在市")
    private String city;

    @ApiModelProperty(value = "所在区")
    private String area;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @ApiModelProperty(value = "备注")
    private String remark;





}
