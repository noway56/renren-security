package com.luming.modules.crm.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Class: com.luming.modules.crm.form.CustomerDirectForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-04 18:13
 */
@Data
@ApiModel(value = "CustomerDirectForm", description = "客户直客表单")
public class CustomerDirectForm extends CustomerFromCompanyForm{

    @ApiModelProperty(value = "租户id")
    @NotNull(message="租户id不能为空")
    private Long tenantId;

    /**
     * 对应的公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Long companyId;
    /**
     * 业务所属公司
     */
    @ApiModelProperty(value = "业务所属公司")
    private Long businessOwnerId;
    /**
     *  业务所属公司名字
     */
    @ApiModelProperty(value = "业务所属公司名字")
    private String businessOwnerName;
    /**
     * 业务所属用户
     */
    @ApiModelProperty(value = "业务所属用户")
    private Long businessOwnerUserId;
    /**
     * 业务所属用户名字
     */
    @ApiModelProperty(value = "业务所属用户名字")
    private String businessOwnerUserName;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "客户名称")
    @NotBlank(message="客户名不能为空")
    private String name;
    /**
     * 客户编码
     */
    @ApiModelProperty(value = "客户编码")
    private String code;
    /**
     * 客户需求
     */
    @ApiModelProperty(value = "客户需求")
    private String customerNeeds;
    /**
     * 客户阶段
     */
    @ApiModelProperty(value = "客户跟进阶段")
    @NotBlank(message="客户跟进阶段不能为空")
    private String customerCommunicationStage;
    /**
     * 客户核心产品
     */
    @ApiModelProperty(value = "客户核心产品")
    private String customerCoreProduct;
    /**
     * 公司简介
     */
    @ApiModelProperty(value = "公司简介")
    private String intro;
    /**
     * 公司类型, 1: 一般， 2: 小微， 3：自然人(虚拟公司)
     */
    @ApiModelProperty(value = "公司类型, 1: 一般， 2: 小微， 3：自然人(虚拟公司)")
    @NotNull(message="公司类型不能为空")
    private Integer companyType;
    /**
     * 是否为内部
     */
    @ApiModelProperty(value = "是否为内部, 1: 内部， 2: 外部")
    @NotNull(message="是否为内部不能为空")
    private Integer isInternal;
    /**
     * 老板姓名
     */
    @ApiModelProperty(value = "老板姓名")
    private String bossName;
    /**
     *  老板手机号
     */
    @ApiModelProperty(value = "老板手机号")
    private String bossPhone;
    /**
     * 老板邮箱
     */
    @ApiModelProperty(value = "老板邮箱")
    private String bossEmail;
    /**
     * 所在省
     */
    @ApiModelProperty(value = "所在省")
    private String province;
    /**
     * 所在市
     */
    @ApiModelProperty(value = "所在市")
    private String city;
    /**
     * 所在区
     */
    @ApiModelProperty(value = "所在区")
    private String area;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


}
