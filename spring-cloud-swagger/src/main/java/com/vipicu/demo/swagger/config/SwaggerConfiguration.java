package com.vipicu.demo.swagger.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.Map;

/**
 * swagger配置
 *
 * @author Administrator
 * @since 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final SwaggerProperties swaggerProperties;


    @Bean
    public OpenAPI customOpenAPI() {
        SwaggerProperties.Info info = swaggerProperties.getInfo();
        return new OpenAPI()
                .info(new Info()
                        .title(info.getTitle())
                        .version(info.getVersion())
                        .description(info.getDescription())
                        .termsOfService(info.getTermsOfService())
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
        Scopes scopes = new Scopes();
        SwaggerProperties.Oauth2 oauth2 = swaggerProperties.getOauth2();
        oauth2.getScopes().forEach(scopes::addString);
        SecurityScheme passwordFlowScheme = new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(new OAuthFlows()
                        .authorizationCode(
                                new OAuthFlow().tokenUrl(oauth2.getTokenUrl())
                                        .authorizationUrl(oauth2.getAuthorizationUrl())
                                        .refreshUrl(oauth2.getRedirectUrl())
                                        .scopes(scopes)
                        )
                );

        return new Components()
                .securitySchemes(Map.of("Password Flow", passwordFlowScheme));
    }
}
