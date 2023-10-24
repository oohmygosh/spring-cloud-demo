package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Schema
@Data
@TableName(value = "main.sys_role")
public class SysRole implements Serializable {
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

    @TableField(value = "\"name\"")
    @Schema(description="")
    private String name;

    @TableField(value = "\"alias\"")
    @Schema(description="")
    private String alias;

    @TableField(value = "remark")
    @Schema(description="")
    private String remark;

    @TableField(value = "\"status\"")
    @Schema(description="")
    private Integer status;

    @TableField(value = "sort")
    @Schema(description="")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}