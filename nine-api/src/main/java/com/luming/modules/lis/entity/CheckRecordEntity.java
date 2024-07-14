package com.luming.modules.lis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 检测记录
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-26 16:42:47
 */
@Data
@TableName("lis_check_record")
public class CheckRecordEntity implements Serializable {
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
	 * 检测时间
	 */
	private Date recordTime;
	/**
	 * 检测人
	 */
	private Long recordPerson;
	/**
	 * 检测状态
	 */
	private Integer recordStatus;
	/**
	 * 模板id
	 */
	private Long templateId;
	/**
	 * 检测结果
	 */
	private String result;
	/**
	 * 备注
	 */
	private String remark;
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
