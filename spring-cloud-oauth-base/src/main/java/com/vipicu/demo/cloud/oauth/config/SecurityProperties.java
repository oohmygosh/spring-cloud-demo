package com.vipicu.demo.cloud.oauth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @since 1.0.0
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("security")
public class SecurityProperties {
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 客户机id
     */
    private String clientId;
    /**
     * 客户秘密
     */
    private String clientSecret;
    /**
     * 重定向uri
     */
    private String redirectUri;
    /**
     * 范围
     */
    private String scope;
    /**
     * 令牌uri
     */
    private String tokenUri;
    /**
     * 用户信息uri
     */
    private String userInfoUri;
    /**
     * 用户信息成功
     */
    private String userInfoSuccessUri;
    /**
     * 用户信息失败uri
     */
    private String userInfoFailureUri;
    /**
     * 用户信息访问被拒绝
     */
    private String userInfoAccessDeniedUri;
    /**
     * 用户信息注销uri
     */
    private String userInfoLogoutUri;
    /**
     * User info logout success uri
     */
    private String userInfoLogoutSuccessUri;
    /**
     * 用户info注销失败uri
     */
    private String userInfoLogoutFailureUri;
    /**
     * 用户信息注销访问被拒绝uri
     */
    private String userInfoLogoutAccessDeniedUri;
}
