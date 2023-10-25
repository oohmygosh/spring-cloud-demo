package com.vipicu.demo.service.advice;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.vipicu.demo.cloud.core.entity.ApiResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 自定义响应体通知
 * 包装Controller返回类型
 *
 * @author Lee
 * @since 1.0.0
 */
public interface ApiResponseBodyAdvice extends ResponseBodyAdvice<Object> {
    @Override
    default boolean supports(final  MethodParameter returnType,
                            final Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    default Object beforeBodyWrite(final @Nullable Object body,
                                  final MethodParameter returnType,
                                  final MediaType selectedContentType,
                                  final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  final ServerHttpRequest request,
                                  final ServerHttpResponse response) {
        if (body instanceof ApiResult<?>) {
            return body;
        }
        ApiResult<Object> success = ApiResult.result(body, 200, "Success");
        // 字符串類型特殊處理
        if (returnType.getParameterType().isAssignableFrom(String.class)) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JacksonUtils.toJson(success);
        }
        return success;
    }
}
