package com.vipicu.demo.cloud.server01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudService01 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudService01.class, args);
    }
}