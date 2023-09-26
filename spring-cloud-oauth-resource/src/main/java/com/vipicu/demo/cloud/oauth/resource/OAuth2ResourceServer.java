package com.vipicu.demo.cloud.oauth.resource;

import com.vipicu.demo.cloud.db.h2.config.EnableDefaultDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Oauth2资源服务器
 *
 * @author Administrator
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDefaultDataSource
public class OAuth2ResourceServer {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceServer.class);
    }

}
