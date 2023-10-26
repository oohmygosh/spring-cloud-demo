package com.vipicu.demo.cloud.db.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
@TableName(value = "OAUTH2_AUTHORIZATION_CONSENT")
public class Oauth2AuthorizationConsent {
    @TableId(value = "REGISTERED_CLIENT_ID", type = IdType.INPUT)
    @Schema(description="注册客户端ID")
    private String registeredClientId;

    @TableField(value = "PRINCIPAL_NAME")
    @Schema(description="用户名")
    private String principalName;

    @TableField(value = "AUTHORITIES")
    @Schema(description="授权")
    private String authorities;
}
