package com.vipicu.demo.cloud.service.resource03.app;

import com.vipicu.demo.cloud.db.h2.config.EnableDefaultDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDefaultDataSource
public class SpringCloudResource03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource03Application.class, args);
    }

}
