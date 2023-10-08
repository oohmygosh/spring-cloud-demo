package com.vipicu.demo.cloud.service.resource02.config;

import com.vipicu.demo.service.advice.ApiResponseBodyAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义响应建议
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestControllerAdvice({"com.vipicu.demo.cloud.service.resource02"})
public class CustomResponseAdvice extends ApiResponseBodyAdvice {
}
