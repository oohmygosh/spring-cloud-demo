package com.vipicu.demo.cloud.oauth.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class SecurityCustomExtensionConfiguration
		extends AbstractHttpConfigurer<SecurityCustomExtensionConfiguration, HttpSecurity> {

	@Override
	public void init(HttpSecurity http) throws Exception {

	}

}
