package com.vipicu.demo.cloud.service.resource01;

import com.vipicu.demo.cloud.db.h2.config.EnableDefaultDataSource;
import com.vipicu.demo.cloud.service.resource01.feign.OAuthRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;

@EnableFeignClients
@SpringBootApplication
@EnableDefaultDataSource
public class SpringCloudResource01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource01Application.class, args);
    }

    /**
     * 注入 oauth2 feign token 增强
     * @return 拦截器
     */
    @Bean
    public RequestInterceptor oauthRequestInterceptor() {
        return new OAuthRequestInterceptor(new DefaultBearerTokenResolver());
    }
}
