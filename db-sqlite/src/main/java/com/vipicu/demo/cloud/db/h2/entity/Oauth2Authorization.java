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
@TableName(value = "PUBLIC.OAUTH2_AUTHORIZATION")
public class Oauth2Authorization {
    @TableId(value = "ID", type = IdType.INPUT)
    @Schema(description="")
    private String id;

    @TableField(value = "REGISTERED_CLIENT_ID")
    @Schema(description="")
    private String registeredClientId;

    @TableField(value = "PRINCIPAL_NAME")
    @Schema(description="")
    private String principalName;

    @TableField(value = "AUTHORIZATION_GRANT_TYPE")
    @Schema(description="")
    private String authorizationGrantType;

    @TableField(value = "AUTHORIZED_SCOPES")
    @Schema(description="")
    private String authorizedScopes;

    @TableField(value = "\"ATTRIBUTES\"")
    @Schema(description="")
    private byte[] attributes;

    @TableField(value = "\"STATE\"")
    @Schema(description="")
    private String state;

    @TableField(value = "AUTHORIZATION_CODE_VALUE")
    @Schema(description="")
    private byte[] authorizationCodeValue;

    @TableField(value = "AUTHORIZATION_CODE_ISSUED_AT")
    @Schema(description="")
    private Date authorizationCodeIssuedAt;

    @TableField(value = "AUTHORIZATION_CODE_EXPIRES_AT")
    @Schema(description="")
    private Date authorizationCodeExpiresAt;

    @TableField(value = "AUTHORIZATION_CODE_METADATA")
    @Schema(description="")
    private byte[] authorizationCodeMetadata;

    @TableField(value = "ACCESS_TOKEN_VALUE")
    @Schema(description="")
    private byte[] accessTokenValue;

    @TableField(value = "ACCESS_TOKEN_ISSUED_AT")
    @Schema(description="")
    private Date accessTokenIssuedAt;

    @TableField(value = "ACCESS_TOKEN_EXPIRES_AT")
    @Schema(description="")
    private Date accessTokenExpiresAt;

    @TableField(value = "ACCESS_TOKEN_METADATA")
    @Schema(description="")
    private byte[] accessTokenMetadata;

    @TableField(value = "ACCESS_TOKEN_TYPE")
    @Schema(description="")
    private String accessTokenType;

    @TableField(value = "ACCESS_TOKEN_SCOPES")
    @Schema(description="")
    private String accessTokenScopes;

    @TableField(value = "OIDC_ID_TOKEN_VALUE")
    @Schema(description="")
    private byte[] oidcIdTokenValue;

    @TableField(value = "OIDC_ID_TOKEN_ISSUED_AT")
    @Schema(description="")
    private Date oidcIdTokenIssuedAt;

    @TableField(value = "OIDC_ID_TOKEN_EXPIRES_AT")
    @Schema(description="")
    private Date oidcIdTokenExpiresAt;

    @TableField(value = "OIDC_ID_TOKEN_METADATA")
    @Schema(description="")
    private byte[] oidcIdTokenMetadata;

    @TableField(value = "REFRESH_TOKEN_VALUE")
    @Schema(description="")
    private byte[] refreshTokenValue;

    @TableField(value = "REFRESH_TOKEN_ISSUED_AT")
    @Schema(description="")
    private Date refreshTokenIssuedAt;

    @TableField(value = "REFRESH_TOKEN_EXPIRES_AT")
    @Schema(description="")
    private Date refreshTokenExpiresAt;

    @TableField(value = "REFRESH_TOKEN_METADATA")
    @Schema(description="")
    private byte[] refreshTokenMetadata;

    @TableField(value = "USER_CODE_VALUE")
    @Schema(description="")
    private byte[] userCodeValue;

    @TableField(value = "USER_CODE_ISSUED_AT")
    @Schema(description="")
    private Date userCodeIssuedAt;

    @TableField(value = "USER_CODE_EXPIRES_AT")
    @Schema(description="")
    private Date userCodeExpiresAt;

    @TableField(value = "USER_CODE_METADATA")
    @Schema(description="")
    private byte[] userCodeMetadata;

    @TableField(value = "DEVICE_CODE_VALUE")
    @Schema(description="")
    private byte[] deviceCodeValue;

    @TableField(value = "DEVICE_CODE_ISSUED_AT")
    @Schema(description="")
    private Date deviceCodeIssuedAt;

    @TableField(value = "DEVICE_CODE_EXPIRES_AT")
    @Schema(description="")
    private Date deviceCodeExpiresAt;

    @TableField(value = "DEVICE_CODE_METADATA")
    @Schema(description="")
    private byte[] deviceCodeMetadata;
}
