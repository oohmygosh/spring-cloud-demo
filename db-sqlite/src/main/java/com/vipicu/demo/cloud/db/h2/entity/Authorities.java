package com.vipicu.demo.cloud.db.h2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
@TableName(value = "AUTHORITIES")
public class Authorities {
    @TableField(value = "USERNAME")
    @Schema(description="用户名")
    private String username;

    @TableField(value = "AUTHORITY")
    @Schema(description="权限")
    private String authority;
}
