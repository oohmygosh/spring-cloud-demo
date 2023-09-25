package com.vipicu.demo.cloud.oauth.resource.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.Map;

/**
 * 开放API配置
 *
 * @author Administrator
 * @since 1.0.0
 */
@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name:api}")
    private String applicationName;
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(applicationName)
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OAuth2 资源服务")
                        .version("1.0")
                        .description("OAuth2 资源服务例子")
                        .termsOfService("http://www.vipicu.com")
                )
                // 添加请求头
                .addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                // oauth2 认证配置
                .components(oauth2Component());
    }

    /**
     * oauth2认证
     * @return {@link Components}
     */
    private Components oauth2Component() {
        SecurityScheme passwordFlowScheme = new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(new OAuthFlows()
                        .authorizationCode(
                                new OAuthFlow().tokenUrl("http://127.0.0.1:8080/oauth2/token")
                                        .authorizationUrl("http://127.0.0.1:8080/oauth2/authorize?scope=message.read")
                                        .refreshUrl("http://127.0.0.1:8081/webjars/oauth/oauth2.html")
                                        .scopes(new Scopes().addString("openid", "获取用户信息"))
                        )
                );

        return new Components()
                .securitySchemes(Map.of("Password Flow", passwordFlowScheme));
    }
}
