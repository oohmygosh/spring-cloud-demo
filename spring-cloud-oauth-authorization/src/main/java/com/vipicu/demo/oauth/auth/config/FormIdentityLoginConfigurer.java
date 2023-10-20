package com.vipicu.demo.oauth.auth.config;

import com.vipicu.demo.cloud.oauth.config.CustomExtensionConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class FormIdentityLoginConfigurer extends CustomExtensionConfigurer {
    @Override
    public void init(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
    }
}
