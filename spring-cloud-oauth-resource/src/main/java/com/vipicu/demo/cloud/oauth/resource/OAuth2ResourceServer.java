package com.vipicu.demo.security.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Oauth2资源服务器
 *
 * @author Administrator
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScans(value = {
    @ComponentScan("com.vipicu.demo.*")
})
@MapperScan("com.vipicu.demo.*.mapper")
public class OAuth2ResourceServer {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceServer.class);
    }

}
