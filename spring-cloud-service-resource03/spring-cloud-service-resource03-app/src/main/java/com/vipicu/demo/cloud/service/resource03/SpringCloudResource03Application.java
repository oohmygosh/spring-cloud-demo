package com.vipicu.demo.cloud.service.resource03;

import com.vipicu.demo.cloud.db.sqlite.config.DefaultDataSourceAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients
@SpringBootApplication
@Import(DefaultDataSourceAutoConfig.class)
public class SpringCloudResource03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudResource03Application.class, args);
    }

}
