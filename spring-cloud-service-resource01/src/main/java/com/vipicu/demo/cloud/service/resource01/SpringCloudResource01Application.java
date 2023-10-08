package com.vipicu.demo.cloud.service.resource01;

import com.vipicu.demo.cloud.db.h2.config.EnableDefaultDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDefaultDataSource
public class SpringCloudResource01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource01Application.class, args);
    }
}
