package com.luming.modules.lis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 检测详情
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@Data
@TableName("lis_check_detail")
public class CheckDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@TableId
	private Long tenantId;
	/**
	 * 检测记录id
	 */
	private Long recordId;
	/**
	 * 检测项目id
	 */
	private Long itemId;
	/**
	 * 检测指标id
	 */
	private Long specId;
	/**
	 * 检测指标名称
	 */
	private String specName;
	/**
	 * 原始数据，一般为多次测量具体值，采用json方式存储
	 */
	private String rawData;
	/**
	 * 检测指标值
	 */
	private String specValue;
	/**
	 * 检测指标单位
	 */
	private String specUnit;
	/**
	 * 检测指标结果
	 */
	private Integer specResult;
	/**
	 * 检测指标备注
	 */
	private String specRemark;
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
