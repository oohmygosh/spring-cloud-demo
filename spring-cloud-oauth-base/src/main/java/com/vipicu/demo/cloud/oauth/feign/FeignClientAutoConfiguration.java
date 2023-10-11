package com.vipicu.demo.cloud.oauth.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;

@Configuration
public class FeignClientAutoConfiguration {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2RequestInterceptor(new DefaultBearerTokenResolver());
    }

}
