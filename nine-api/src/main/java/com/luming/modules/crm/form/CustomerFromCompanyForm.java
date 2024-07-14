package com.luming.modules.crm.form;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Class: com.luming.modules.crm.form.CustomerFromCompanyForm
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-04 18:15
 */
@Data
public class CustomerFromCompanyForm {

    /**
     *租户
     */
    private Long tenantId;
    /**
     * 对应的公司ID
     */
    private Long companyId;
    /**
     * 业务所属公司  businessOwnerId
     */
    private Long businessOwnerId;
    /**
     * 业务所属公司名字
     */
    private String businessOwnerName;
    /**
     * 业务所属用户
     */
    private Long businessOwnerUserId;
    /**
     * 业务所属用户名字
     */
    private String businessOwnerUserName;
    /**
     * 客户编码
     */
    private String code;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 客户需求
     */
    private String customerNeeds;
    /**
     * 客户阶段
     */
    private String customerCommunicationStage;
    /**
     * 客户核心产品
     */
    @ApiModelProperty(value = "客户核心产品")
    private String customerCoreProduct;
}
