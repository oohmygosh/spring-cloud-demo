package com.vipicu.demo.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema
@Data
@TableName(value = "PUBLIC.OAUTH2_REGISTERED_CLIENT")
public class Oauth2RegisteredClient {
    @TableId(value = "ID", type = IdType.INPUT)
    @Schema(description="")
    private String id;

    @TableField(value = "CLIENT_ID")
    @Schema(description="")
    private String clientId;

    @TableField(value = "CLIENT_ID_ISSUED_AT")
    @Schema(description="")
    private Date clientIdIssuedAt;

    @TableField(value = "CLIENT_SECRET")
    @Schema(description="")
    private String clientSecret;

    @TableField(value = "CLIENT_SECRET_EXPIRES_AT")
    @Schema(description="")
    private Date clientSecretExpiresAt;

    @TableField(value = "CLIENT_NAME")
    @Schema(description="")
    private String clientName;

    @TableField(value = "CLIENT_AUTHENTICATION_METHODS")
    @Schema(description="")
    private String clientAuthenticationMethods;

    @TableField(value = "AUTHORIZATION_GRANT_TYPES")
    @Schema(description="")
    private String authorizationGrantTypes;

    @TableField(value = "REDIRECT_URIS")
    @Schema(description="")
    private String redirectUris;

    @TableField(value = "POST_LOGOUT_REDIRECT_URIS")
    @Schema(description="")
    private String postLogoutRedirectUris;

    @TableField(value = "SCOPES")
    @Schema(description="")
    private String scopes;

    @TableField(value = "CLIENT_SETTINGS")
    @Schema(description="")
    private String clientSettings;

    @TableField(value = "TOKEN_SETTINGS")
    @Schema(description="")
    private String tokenSettings;
}
