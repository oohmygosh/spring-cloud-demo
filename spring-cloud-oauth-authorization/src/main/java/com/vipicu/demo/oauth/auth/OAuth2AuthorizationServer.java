package com.vipicu.demo.oauth.auth;

import com.vipicu.demo.cloud.db.h2.config.EnableDefaultDataSource;
import com.vipicu.demo.cloud.feign.config.annotations.EnableMakerFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMakerFeignClients
@SpringBootApplication
@EnableDefaultDataSource
public class OAuth2AuthorizationServer {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2AuthorizationServer.class, args);
    }
}
