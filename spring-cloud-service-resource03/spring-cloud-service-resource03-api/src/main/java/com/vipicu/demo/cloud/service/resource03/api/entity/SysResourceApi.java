package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Schema
@Data
@TableName(value = "main.sys_resource_api")
public class SysResourceApi implements Serializable {
    @TableField(value = "id")
    @Schema(description="")
    private Integer id;

    @TableField(value = "resource_id")
    @Schema(description="")
    private Integer resourceId;

    @TableField(value = "url")
    @Schema(description="")
    private String url;

    @TableField(value = "code")
    @Schema(description="")
    private String code;

    @Serial
    private static final long serialVersionUID = 1L;
}