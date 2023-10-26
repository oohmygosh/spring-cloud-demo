package com.vipicu.demo.cloud.service.resource01;

import com.vipicu.demo.cloud.db.sqlite.config.EnableDefaultDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDefaultDataSource
public class SpringCloudResource01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource01Application.class, args);
    }
}
