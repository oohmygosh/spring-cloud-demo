package com.vipicu.demo.service.advice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ConditionalOnMissingClass
@RestControllerAdvice("com.vipicu.demo.*")
public class DefaultApiResponseBodyAdvice implements ApiResponseBodyAdvice {
}
