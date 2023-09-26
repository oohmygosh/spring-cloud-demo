package com.vipicu.demo.cloud.gateway;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * Spring云网关应用
 *
 * @author Administrator
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SpringCloudGatewayApplication.class, args);
        Environment env = application.getEnvironment();
        System.out.printf("""
                        ----------------------------------------------------------
                        \tApplication '%s' is running! Access URLs:
                        \tLocal: \t\thttp://127.0.0.1:%s
                        \tExternal: \thttp://%s:%s
                        \tDoc: \thttp://%S:%s/doc.html
                        ----------------------------------------------------------
                        """,
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                "127.0.0.1",
                env.getProperty("server.port"));
    }
}