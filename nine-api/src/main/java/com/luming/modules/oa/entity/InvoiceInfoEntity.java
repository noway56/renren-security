package com.luming.modules.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 开票信息
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-16 12:40:21
 */
@Data
@TableName("oa_invoice_info")
public class InvoiceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 公司id
	 */
	private Long companyId;
	/**
	 * ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	/**
	 * 发票抬头
	 */
	private String title;
	/**
	 * 公司税号
	 */
	private String taxNumber;
	/**
	 * 单位地址
	 */
	private  String address;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 开户银行
	 */
	private String bank;
	/**
	 * 银行账户
	 */
	private String bankAccount;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 生成时间
	 */
	private Long createTime;
	/**
     * 更新时间
     */
	private Long updateTime;
	/**
     * 是否删除  1：已删除  0：正常
     */
	private Integer isDeleted;
	/**
	 * 删除时间
	 */
	private Long deleteTime;

}
