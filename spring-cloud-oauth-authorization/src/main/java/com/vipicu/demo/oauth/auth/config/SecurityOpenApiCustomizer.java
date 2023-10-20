package com.vipicu.demo.oauth.auth.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Configuration
public class SecurityOpenApiCustomizer implements GlobalOpenApiCustomizer {
    @Override
    public void customise(OpenAPI openApi) {
        Parameter authorization = new HeaderParameter().name("Authorization").required(true).example("Basic bWVzc2FnaW5nLWNsaWVudDpzZWNyZXQ=").schema(new StringSchema()).description("bearer token");
        Parameter scope = new Parameter().name("scope").example("message.read").schema(new StringSchema()).required(true).description("scope");
        openApi.path("/oauth2/token?grant_type=password", new PathItem()
                        .post(
                                new Operation().description("Oauth2密码模式")
                                        .addTagsItem("Security")
                                        .operationId("Oauth2密码模式")
                                        .parameters(
                                                List.of(
                                                        new Parameter().name("username").example("admin").required(true).schema(new StringSchema()).description("用户名"),
                                                        new Parameter().name("password").example("admin").required(true).schema(new StringSchema()).description("密码"),
                                                        scope,
                                                        authorization
                                                )
                                        )
                        )
                )
                .path("/oauth2/token?grant_type=authorization_code", new PathItem()
                        .post(
                                new Operation().description("Oauth2授权码模式")
                                        .addTagsItem("Security")
                                        .operationId("Oauth2授权码模式")
                                        .parameters(
                                                List.of(
                                                        new Parameter().name("code").required(true).schema(new StringSchema()).description("授权码"),
                                                        new Parameter().name("redirect_uri").required(true).schema(new StringSchema()).description("重定向uri"),
                                                        scope,
                                                        authorization
                                                )
                                        )))
                .path("/oauth2/token?grant_type=refresh_token", new PathItem()
                        .post(
                                new Operation().description("Oauth2刷新Token")
                                        .addTagsItem("Security")
                                        .operationId("Oauth2刷新Token")
                                        .parameters(
                                                List.of(
                                                        new Parameter().name("refresh_token").required(true).schema(new StringSchema()).description("刷新Token"),
                                                        authorization
                                                )
                                        )))
                .path("/userinfo", new PathItem().get(
                        new Operation().description("OIDC用户信息")
                                .addTagsItem("Security")
                                .operationId("OIDC用户信息")
                ));
    }

}
