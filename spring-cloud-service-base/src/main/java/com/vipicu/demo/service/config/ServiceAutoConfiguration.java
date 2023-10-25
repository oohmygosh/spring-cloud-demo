package com.vipicu.demo.service.config;

import com.vipicu.demo.service.advice.ApiResponseBodyAdvice;
import com.vipicu.demo.service.advice.DefaultApiResponseBodyAdvice;
import com.vipicu.demo.service.openapi.CustomGenericResponseService;
import com.vipicu.demo.service.openapi.GlobalOpenApiResponse;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OperationService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * 服务自动配置
 *
 * @author Administrator
 * @since 1.0.0
 */
@Lazy(false)
@Configuration(proxyBeanMethods = false)
public class ServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ApiResponseBodyAdvice.class)
    public ApiResponseBodyAdvice defaultApiResponseBodyAdvice() {
        return new DefaultApiResponseBodyAdvice();
    }

    @Bean
    @Lazy(false)
    @ConditionalOnBean(ApiResponseBodyAdvice.class)
    public GenericResponseService responseBuilder(OperationService operationService, List<ReturnTypeParser> returnTypeParsers, SpringDocConfigProperties springDocConfigProperties, PropertyResolverUtils propertyResolverUtils) {
        return new CustomGenericResponseService(operationService, returnTypeParsers, springDocConfigProperties, propertyResolverUtils);
    }

    @Bean
    public GlobalOpenApiResponse globalOpenApiResponse() {
        return new GlobalOpenApiResponse();
    }
}
