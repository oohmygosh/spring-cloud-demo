package com.vipicu.demo.service.advice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice("com.vipicu.demo.*")
public class DefaultApiResponseBodyAdvice implements ApiResponseBodyAdvice {
}
