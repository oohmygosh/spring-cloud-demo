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

import java.util.List;

@Slf4j
@Configuration
public class SecurityOpenApiCustomizer implements GlobalOpenApiCustomizer {
    @Override
    public void customise(OpenAPI openApi) {
        openApi.path("/oauth2/token", new PathItem().post(
                new Operation().description("Oauth2密码认证")
                        .addTagsItem("Security")
                        .operationId("Oauth2密码认证")
                        .parameters(
                                List.of(
                                        new Parameter().name("username").example("admin").schema(new StringSchema()).description("用户名"),
                                        new Parameter().name("password").example("admin").schema(new StringSchema()).description("密码"),
                                        new Parameter().name("code").schema(new StringSchema()).description("授权码"),
                                        new Parameter().name("redirect_uri").schema(new StringSchema()).description("重定向uri"),
                                        new Parameter().name("grant_type").example("password").schema(new StringSchema()).required(true).description("类型"),
                                        new HeaderParameter().name("Authorization").required(true).example("Basic bWVzc2FnaW5nLWNsaWVudDpzZWNyZXQ=").schema(new StringSchema()).description("bearer token")
                                )
                        )
                        .responses(new ApiResponses()
                                .addApiResponse("200", new ApiResponse().description("登录成功"))))
        ).path("/userinfo", new PathItem().get(
                new Operation().description("用户信息")
                        .addTagsItem("Security")
                        .operationId("用户信息")
                        .responses(new ApiResponses()
                                .addApiResponse("200", new ApiResponse().description("登录成功"))))
        )
        ;
    }

}
