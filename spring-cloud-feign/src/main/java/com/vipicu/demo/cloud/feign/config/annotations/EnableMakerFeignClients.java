package com.vipicu.demo.cloud.feign.config.annotations;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableMakerFeignClients {


    String[] value() default {};


    @AliasFor(annotation = EnableFeignClients.class, attribute = "basePackages")
    String[] basePackages() default { "com.vipicu.demo" };

}
