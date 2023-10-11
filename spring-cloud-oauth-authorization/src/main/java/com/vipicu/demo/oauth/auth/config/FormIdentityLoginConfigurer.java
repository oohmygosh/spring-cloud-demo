package com.vipicu.demo.oauth.auth.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

/**
 * @author lengleng
 * @data 2022-06-04
 *
 * 基于授权码模式 统一认证登录 spring security & sas 都可以使用 所以抽取成 HttpConfigurer
 */
public final class FormIdentityLoginConfigurer
		extends AbstractHttpConfigurer<FormIdentityLoginConfigurer, HttpSecurity> {

	@Override
	public void init(HttpSecurity http) throws Exception {
		http.formLogin(Customizer.withDefaults());
	}

}
