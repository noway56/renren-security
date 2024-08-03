package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Class: com.luming.modules.crm.entity.ProductEntity
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-29 00:40
 */
@Data
@TableName("crm_product")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户
     */
    private Long tenantId;
    /**
     *  产品id
     */
    @TableId
    private Long productId;
    /**
     *  产品名称
     */
    private String name;
    /**
     *   产品编码
     */
    private String code;
    /**
     *  所属类别
     */
    private Long categoryId;
    /**
     *  所属类别名称
     */
    private String categoryName;
    /**
     * 是否自产
     */
    private Integer isSelfMade;
    /**
     * 关联配方id
     */
    private Long formulaId;
    /**
     * 关联配方编码
     */
    private String formulaCode;
    /**
     *   产品描述
     */
    private String remark;
    /**
     * 产品描述
     */
    private String description;
    /**
     * 不含税成本
     */
    private Integer taxFreeCost;
    /**
     * 含税成本
     */
    private Integer cost;
    /**
     * 建议不含税出厂价
     */
    private Integer  suggestTaxFreePrice;
    /**
     * 建议含税出厂价
     */
    private Integer suggestPrice;
    /**
     *  库存
     */
    private Integer stock;
    /**
     *  单位
     */
    private String stockUnit;
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
