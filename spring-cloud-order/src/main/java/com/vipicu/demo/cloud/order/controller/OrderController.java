package com.vipicu.demo.cloud.order.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @since 1.0.0
 */
@RestController
@Tag(name = "订单")
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String getOrder() {
        return  "order";
    }

}
