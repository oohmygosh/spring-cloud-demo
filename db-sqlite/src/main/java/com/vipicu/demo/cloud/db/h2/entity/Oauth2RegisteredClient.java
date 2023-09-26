package com.vipicu.demo.cloud.db.h2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema
@Data
@TableName(value = "OAUTH2_REGISTERED_CLIENT")
public class Oauth2RegisteredClient {
    @TableId(value = "ID", type = IdType.INPUT)
    @Schema(description="主键")
    private String id;

    @TableField(value = "CLIENT_ID")
    @Schema(description="客户端ID")
    private String clientId;

    @TableField(value = "CLIENT_ID_ISSUED_AT")
    @Schema(description="客户端ID创建时间")
    private Date clientIdIssuedAt;

    @TableField(value = "CLIENT_SECRET")
    @Schema(description="客户端密钥")
    private String clientSecret;

    @TableField(value = "CLIENT_SECRET_EXPIRES_AT")
    @Schema(description="过期时间")
    private Date clientSecretExpiresAt;

    @TableField(value = "CLIENT_NAME")
    @Schema(description="客户端名称")
    private String clientName;

    @TableField(value = "CLIENT_AUTHENTICATION_METHODS")
    @Schema(description="授权方法")
    private String clientAuthenticationMethods;

    @TableField(value = "AUTHORIZATION_GRANT_TYPES")
    @Schema(description="授权类型")
    private String authorizationGrantTypes;

    @TableField(value = "REDIRECT_URIS")
    @Schema(description="重定向URI")
    private String redirectUris;

    @TableField(value = "POST_LOGOUT_REDIRECT_URIS")
    @Schema(description="注销重定向URI")
    private String postLogoutRedirectUris;

    @TableField(value = "SCOPES")
    @Schema(description="scopes")
    private String scopes;

    @TableField(value = "CLIENT_SETTINGS")
    @Schema(description="客户端设置")
    private String clientSettings;

    @TableField(value = "TOKEN_SETTINGS")
    @Schema(description="令牌设置")
    private String tokenSettings;
}
