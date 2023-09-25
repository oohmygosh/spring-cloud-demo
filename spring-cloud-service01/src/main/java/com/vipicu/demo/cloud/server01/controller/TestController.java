package com.vipicu.demo.cloud.server01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestController
public class TestController {

    @GetMapping
    public String test() {
        return "Hello World!";
    }

}
