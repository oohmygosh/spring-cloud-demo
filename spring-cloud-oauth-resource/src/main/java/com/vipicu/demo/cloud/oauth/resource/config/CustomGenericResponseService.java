package com.vipicu.demo.cloud.oauth.resource.config;

import com.fasterxml.jackson.annotation.JsonView;
import com.vipicu.demo.cloud.oauth.resource.entity.ApiResult;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Content;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OperationService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 扩展原有的Schemes
 *
 * @author Lee
 * @since 1.0.0
 */
@Slf4j
@Component
public class CustomGenericResponseService extends GenericResponseService {
    /**
     * Instantiates a new Generic response builder.
     *
     * @param operationService          the operation builder
     * @param returnTypeParsers         the return type parsers
     * @param springDocConfigProperties the spring doc config properties
     * @param propertyResolverUtils     the property resolver utils
     */
    public CustomGenericResponseService(OperationService operationService, List<ReturnTypeParser> returnTypeParsers, SpringDocConfigProperties springDocConfigProperties, PropertyResolverUtils propertyResolverUtils) {
        super(operationService, returnTypeParsers, springDocConfigProperties, propertyResolverUtils);
        log.debug("==========CustomGenericResponseService==========");
    }

    /**
     * 扩展原来的方法，修改接口返回类型为真实类型
     *
     * @param components     组件
     * @param annotations    注释
     * @param methodProduces 方法生产
     * @param jsonView       json视图
     * @param returnType     返回类型
     * @return {@link Content}
     */
    @Override
    public Content buildContent(Components components, Annotation[] annotations, String[] methodProduces, JsonView jsonView, Type returnType) {
        ResolvableType resolvableType = ResolvableType.forType(returnType);
        if (resolvableType.getRawClass() != ApiResult.class) {
            returnType = ResolvableType.forClassWithGenerics(ApiResult.class, resolvableType).getType();
        }
        return super.buildContent(components, annotations, methodProduces, jsonView, returnType);
    }

}
