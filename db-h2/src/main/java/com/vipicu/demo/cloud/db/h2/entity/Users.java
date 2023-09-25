package com.vipicu.demo.cloud.db.h2.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户",description = "用户信息")
public class Users {
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "启用")
    private Boolean enabled;
}
