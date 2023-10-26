package com.vipicu.demo.cloud.db.sqlite.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan("com.vipicu.demo.*")
@MapperScan("com.vipicu.demo.cloud.db.*.mapper")
@Import(DefaultDataSourceAutoConfig.class)
public @interface EnableDefaultDataSource {
}
