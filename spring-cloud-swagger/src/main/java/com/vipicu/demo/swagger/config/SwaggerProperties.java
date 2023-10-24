package com.vipicu.demo.swagger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * swagger属性
 *
 * @author Administrator
 * @since 1.0.0
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    private OAuth2 oauth2;
    private Info info;

    @Getter
    @Setter
    static class Info {
        /**
         * 标题
         */
        private String title;
        /**
         * 描述
         */
        private String description;
        /**
         * 版本
         */
        private String version;
        /**
         * 服务条款
         */
        private String termsOfService;
    }

    @Getter
    @Setter
    static class OAuth2 {
        /**
         * 授权url
         */
        private String authorizationUrl;
        /**
         * Token url
         */
        private String tokenUrl;
        /**
         * 重定向url
         */
        private String redirectUrl;
        /**
         * 作用域
         */
        private Map<String, String> scopes;
    }

}
