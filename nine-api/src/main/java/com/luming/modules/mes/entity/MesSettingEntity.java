package com.luming.modules.mes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Class: com.luming.modules.mes.entity.MesSettingEntity
 * @Desc:
 * @author: luwu
 * @Date: 2024-07-23 22:54
 */
@Data
@TableName("mes_setting")
public class MesSettingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 配置id
     */
    @TableId
    private Long settingId;
    /**
     * 配置项key
     */
    private String settingKey;
    /**
     * 配置项值
     */
    private String settingValue;
    /**
     * 配置值单位
     */
    private String unit;
    /**
     * 配置项描述
     */
    private String settingDesc;
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
