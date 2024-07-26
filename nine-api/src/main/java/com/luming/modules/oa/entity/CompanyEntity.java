package com.luming.modules.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-16 12:40:21
 */
@Data
@TableName("oa_company")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
	 */
	private Long tenantId;
	/**
	 * 
	 */
	@TableId(type= IdType.ASSIGN_ID)
	private Long companyId;
	/**
	 * 公司名称
	 */
	private String name;
	/**
	 * 公司编码
	 */
	private String code;
	/**
	 * 电话
	 */
	private  String phone;
	/**
	 * 网址
	 */
	private  String website;
	/**
	 * 公司简介
	 */
	private String intro;
	/**
	 * 公司类型, 1: 一般， 2: 小微， 3：自然人(虚拟公司)
	 */
	private Integer companyType;
	/**
	 * 是否为客户
	 */
	private Integer isCustomer;
	/**
     * 是否为供应商
     */
	private Integer isProvider;
	/**
	 * 是否为内部
	 */
	private Integer isInternal;
	/**
	 * 老板姓名
	 */
	private String bossName;
	/**
	 *  老板手机号
	 */
	private String bossPhone;
	/**
     * 老板邮箱
     */
	private String bossEmail;
	/**
	 * 所在省
	 */
	private String province;
	/**
     * 所在市
     */
	private String city;
	/**
     * 所在区
     */
	private String area;
	/**
     * 详细地址
     */
	private String address;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 生成时间
	 */
	private Date createTime;
	/**
     * 更新时间
     */
	private Date updateTime;
	/**
     * 是否删除  1：已删除  0：正常
     */
	private Integer isDeleted;
	/**
	 * 删除时间
	 */
	private Date deleteTime;

}
