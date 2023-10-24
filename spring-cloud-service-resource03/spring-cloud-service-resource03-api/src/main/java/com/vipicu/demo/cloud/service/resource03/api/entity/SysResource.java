package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Schema
@Data
@TableName(value = "sys_resource")
public class SysResource implements Serializable {

    @TableField(value = "id")
    @Schema(description="")
    private Integer id;
    
    @TableField(value = "create_id")
    @Schema(description="")
    private Integer createId;

    @TableField(value = "create_by")
    @Schema(description="")
    private String createBy;

    @TableField(value = "create_time")
    @Schema(description="")
    private Date createTime;

    @TableField(value = "update_by")
    @Schema(description="")
    private String updateBy;

    @TableField(value = "update_time")
    @Schema(description="")
    private Date updateTime;

    @TableField(value = "deleted")
    @Schema(description="")
    private Integer deleted;

    @TableField(value = "pid")
    @Schema(description="")
    private Integer pid;

    @TableField(value = "title")
    @Schema(description="")
    private String title;

    @TableField(value = "\"alias\"")
    @Schema(description="")
    private String alias;

    @TableField(value = "\"type\"")
    @Schema(description="")
    private Integer type;

    @TableField(value = "code")
    @Schema(description="")
    private String code;

    @TableField(value = "redirect")
    @Schema(description="")
    private String redirect;

    @TableField(value = "\"path\"")
    @Schema(description="")
    private String path;

    @TableField(value = "icon")
    @Schema(description="")
    private String icon;

    @TableField(value = "\"status\"")
    @Schema(description="")
    private Integer status;

    @TableField(value = "sort")
    @Schema(description="")
    private Integer sort;

    @TableField(value = "component")
    @Schema(description="")
    private String component;

    @TableField(value = "color")
    @Schema(description="")
    private String color;

    @TableField(value = "hidden")
    @Schema(description="")
    private Boolean hidden;

    @Serial
    private static final long serialVersionUID = 1L;
}