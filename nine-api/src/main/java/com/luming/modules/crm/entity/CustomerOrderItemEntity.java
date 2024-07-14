package com.luming.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售订单明细
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-18 22:34:57
 */
@Data
@TableName("crm_customer_order_item")
public class CustomerOrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 
	 */
	private Long orderItemId;
	/**
	 * 
	 */
	private Long orderId;
	/**
	 * 
	 */
	private Long productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品规格
	 */
	private String productSpec;
	/**
	 * 产品单位
	 */
	private String productUnit;
	/**
	 * 产品数量
	 */
	private Integer productCount;
	/**
	 * 产品单价
	 */
	private Integer productPrice;
	/**
	 * 产品金额
	 */
	private Integer productAmount;
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
