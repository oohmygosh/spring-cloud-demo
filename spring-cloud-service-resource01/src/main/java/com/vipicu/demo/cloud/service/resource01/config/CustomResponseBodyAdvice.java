package com.vipicu.demo.cloud.service.resource01.config;

import com.vipicu.demo.service.advice.ApiResponseBodyAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 自定义响应体通知
 * 包装Controller返回类型
 *
 * @author Lee
 * @since 1.0.0
 */
@RestControllerAdvice({
        "com.vipicu.demo.cloud.service.resource01"
})
public class CustomResponseBodyAdvice extends ApiResponseBodyAdvice {
}
