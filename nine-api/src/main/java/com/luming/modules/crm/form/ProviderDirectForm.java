package com.luming.modules.crm.form;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Class: com.luming.modules.crm.form.ProviderDirectForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-11 16:49
 */
@Data
@ApiModel(value = "ProviderDirectForm", description = "供应商直连表单")
public class ProviderDirectForm {

    @ApiModelProperty(value = "租户id")
    @NotNull(message="租户id不能为空")
    private Long tenantId;

    /**
     * 对应的公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Long companyId;
    /**
     * 供应商ID
     */
    private Long providerId;
    /**
     * 产品类型
     */
    private String productType;

    @ApiModelProperty(value = "供应商名称")
    @NotBlank(message="供应商名不能为空")
    private String name;
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码")
    private String code;
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
