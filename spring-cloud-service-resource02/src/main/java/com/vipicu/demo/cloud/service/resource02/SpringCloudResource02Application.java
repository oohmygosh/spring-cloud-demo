package com.vipicu.demo.cloud.service.resource02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringCloudResource02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource02Application.class, args);
    }

}
