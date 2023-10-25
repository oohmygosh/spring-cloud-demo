package com.vipicu.demo.cloud.service.resource03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
// @EnableDefaultDataSource
public class SpringCloudResource03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource03Application.class, args);
    }

}
