package com.vipicu.demo.cloud.service.resource03.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Data;

@Schema
@Data
@TableName(value = "main.sys_user_role")
public class SysUserRole implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="")
    private Integer id;

    @TableField(value = "user_id")
    @Schema(description="")
    private Integer userId;

    @TableField(value = "role_id")
    @Schema(description="")
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}