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
@TableName(value = "OAUTH2_AUTHORIZATION")
public class Oauth2Authorization {
    @TableId(value = "ID", type = IdType.INPUT)
    @Schema(description="主键")
    private String id;

    @TableField(value = "REGISTERED_CLIENT_ID")
    @Schema(description="注册客户端ID")
    private String registeredClientId;

    @TableField(value = "PRINCIPAL_NAME")
    @Schema(description="用户名")
    private String principalName;

    @TableField(value = "AUTHORIZATION_GRANT_TYPE")
    @Schema(description="授权类型")
    private String authorizationGrantType;

    @TableField(value = "AUTHORIZED_SCOPES")
    @Schema(description="授权范围")
    private String authorizedScopes;

    @TableField(value = "\"ATTRIBUTES\"")
    @Schema(description="属性")
    private byte[] attributes;

    @TableField(value = "\"STATE\"")
    @Schema(description="状态")
    private String state;

    @TableField(value = "AUTHORIZATION_CODE_VALUE")
    @Schema(description="授权码")
    private byte[] authorizationCodeValue;

    @TableField(value = "AUTHORIZATION_CODE_ISSUED_AT")
    @Schema(description="授权码创建时间")
    private Date authorizationCodeIssuedAt;

    @TableField(value = "AUTHORIZATION_CODE_EXPIRES_AT")
    @Schema(description="授权码过期时间")
    private Date authorizationCodeExpiresAt;

    @TableField(value = "AUTHORIZATION_CODE_METADATA")
    @Schema(description="授权码元数据")
    private byte[] authorizationCodeMetadata;

    @TableField(value = "ACCESS_TOKEN_VALUE")
    @Schema(description="访问Token")
    private byte[] accessTokenValue;

    @TableField(value = "ACCESS_TOKEN_ISSUED_AT")
    @Schema(description="访问Token颁发时间")
    private Date accessTokenIssuedAt;

    @TableField(value = "ACCESS_TOKEN_EXPIRES_AT")
    @Schema(description="访问Token过期时间")
    private Date accessTokenExpiresAt;

    @TableField(value = "ACCESS_TOKEN_METADATA")
    @Schema(description="访问Token元数据")
    private byte[] accessTokenMetadata;

    @TableField(value = "ACCESS_TOKEN_TYPE")
    @Schema(description="访问Token类型")
    private String accessTokenType;

    @TableField(value = "ACCESS_TOKEN_SCOPES")
    @Schema(description="访问Token范围")
    private String accessTokenScopes;

    @TableField(value = "OIDC_ID_TOKEN_VALUE")
    @Schema(description="oidcIdToken")
    private byte[] oidcIdTokenValue;

    @TableField(value = "OIDC_ID_TOKEN_ISSUED_AT")
    @Schema(description="oidcIdTokenIssuedAt")
    private Date oidcIdTokenIssuedAt;

    @TableField(value = "OIDC_ID_TOKEN_EXPIRES_AT")
    @Schema(description="oidcIdTokenExpiresAt")
    private Date oidcIdTokenExpiresAt;

    @TableField(value = "OIDC_ID_TOKEN_METADATA")
    @Schema(description="oidcIdTokenMetadata")
    private byte[] oidcIdTokenMetadata;

    @TableField(value = "REFRESH_TOKEN_VALUE")
    @Schema(description="刷新Token")
    private byte[] refreshTokenValue;

    @TableField(value = "REFRESH_TOKEN_ISSUED_AT")
    @Schema(description="刷新Token颁发时间")
    private Date refreshTokenIssuedAt;

    @TableField(value = "REFRESH_TOKEN_EXPIRES_AT")
    @Schema(description="刷新Token过期时间")
    private Date refreshTokenExpiresAt;

    @TableField(value = "REFRESH_TOKEN_METADATA")
    @Schema(description="刷新Token元数据")
    private byte[] refreshTokenMetadata;

    @TableField(value = "USER_CODE_VALUE")
    @Schema(description="用户code")
    private byte[] userCodeValue;

    @TableField(value = "USER_CODE_ISSUED_AT")
    @Schema(description="userCodeIssuedAt")
    private Date userCodeIssuedAt;

    @TableField(value = "USER_CODE_EXPIRES_AT")
    @Schema(description="userCodeExpiresAt")
    private Date userCodeExpiresAt;

    @TableField(value = "USER_CODE_METADATA")
    @Schema(description="userCodeMetadata")
    private byte[] userCodeMetadata;

    @TableField(value = "DEVICE_CODE_VALUE")
    @Schema(description="deviceCodeValue")
    private byte[] deviceCodeValue;

    @TableField(value = "DEVICE_CODE_ISSUED_AT")
    @Schema(description="deviceCodeIssuedAt")
    private Date deviceCodeIssuedAt;

    @TableField(value = "DEVICE_CODE_EXPIRES_AT")
    @Schema(description="deviceCodeExpiresAt")
    private Date deviceCodeExpiresAt;

    @TableField(value = "DEVICE_CODE_METADATA")
    @Schema(description="deviceCodeMetadata")
    private byte[] deviceCodeMetadata;
}
