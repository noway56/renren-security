package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Class: com.luming.modules.crm.entity.CustomerMatchedProductEntity
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-09 23:32
 */
@Data
@TableName("customer_matched_product")
public class CustomerMatchedProductEntity {

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 产品类型ID
     */
    private Long productTypeId;

    /**
     * 匹配关系描述
     */
    private String desc;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 一般订单数量
     */
    private Long number;

    /**
     * 订单数量单位
     */
    private String numberUnit;

    /**
     * 单价
     */
    private Double price;

    /**
     * 运输方式
     */
    private String transportMode;

    /**
     * 单位运输成本
     */
    private Double transportUnitCost;

    /**
     * 单位销售费用
     */
    private Double salesUnitCost;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 删除时间
     */
    private Date deleteTime;
}
