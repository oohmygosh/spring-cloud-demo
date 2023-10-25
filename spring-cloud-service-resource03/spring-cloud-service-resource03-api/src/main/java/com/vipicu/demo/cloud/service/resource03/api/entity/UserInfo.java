package com.vipicu.demo.cloud.service.resource03.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {

    @Schema(description = "用户基本信息")
    private SysUser sysUser;

    @Schema(description = "权限标识")
    private List<String> authorities;

    @Schema(description = "角色")
    private List<String> roles;

}
