package com.vipicu.demo.security.resource.config;

import com.vipicu.demo.security.resource.entity.ApiResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 自定义响应体通知
 * 包装Controller返回类型
 *
 * @author Lee
 * @since 1.0.0
 */
@RestControllerAdvice({
        "com.vipicu.demo.security.resource.controller"
})
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(final  MethodParameter returnType,
                            final Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(final @Nullable Object body,
                                  final MethodParameter returnType,
                                  final MediaType selectedContentType,
                                  final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  final ServerHttpRequest request,
                                  final ServerHttpResponse response) {
        if (body instanceof ApiResult<?>) {
            return body;
        }
        return ApiResult.result(body,200, "Success");
    }
}
