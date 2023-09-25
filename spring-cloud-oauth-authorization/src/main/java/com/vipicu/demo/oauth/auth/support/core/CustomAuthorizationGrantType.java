package com.vipicu.demo.support.core;

import org.springframework.security.oauth2.core.AuthorizationGrantType;

/**
 * 自定义授权授予类型
 *
 * @author Lee
 * @since 1.0.0
 */
public class CustomAuthorizationGrantType {
    public static final AuthorizationGrantType PASSWORD = new AuthorizationGrantType("password");

}
