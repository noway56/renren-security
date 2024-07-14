package com.luming.modules.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门管理
 * 
 * @author luwu
 * @email luwu2015@foxmail.com
 * @date 2024-03-16 12:40:21
 */
@Data
@TableName("oa_dept")
public class DeptEntity implements Serializable {
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
	 * 部门id
	 */
	@TableId(type= IdType.ASSIGN_ID)
	private Long deptId;
	/**
	 * 上级部门ID，一级部门为0
	 */
	private Long parentId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
     * 创建时间
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
