package com.vipicu.demo.cloud.core.annotations;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Cacheable(value = "maker")
public @interface ICacheable {

    @AliasFor(annotation = Cacheable.class, attribute = "value")
    String[] value() default {};


    @AliasFor(annotation = Cacheable.class, attribute = "cacheNames")
    String[] cacheNames() default {};


    @AliasFor(annotation = Cacheable.class, attribute = "key")
    String key() default "";


    @AliasFor(annotation = Cacheable.class, attribute = "keyGenerator")
    String keyGenerator() default "";


    @AliasFor(annotation = Cacheable.class, attribute = "cacheResolver")
    String cacheResolver() default "";


    @AliasFor(annotation = Cacheable.class, attribute = "condition")
    String condition() default "";


    @AliasFor(annotation = Cacheable.class, attribute = "unless")
    String unless() default "";


    @AliasFor(annotation = Cacheable.class, attribute = "sync")
    boolean sync() default false;


    long expiredTimeSecond() default 0;


    long preLoadTimeSecond() default 0;


}
