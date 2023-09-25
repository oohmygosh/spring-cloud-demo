package com.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * nacos 单机运行，方便开发测试
 *
 * @author Lee
 * @since 2023/06/07
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.nacos")
@ServletComponentScan
@EnableScheduling
public class Nacos {

    public static void main(String[] args) {
        if (initEnv()) {
            SpringApplication.run(Nacos.class, args);
        }
    }

    private static boolean initEnv() {
        System.setProperty("nacos.standalone", "true");
        System.setProperty("nacos.core.auth.enabled", "true");
        System.setProperty("server.tomcat.basedir", "logs");
        System.setProperty("server.tomcat.accesslog.enabled", "false");
        return true;
    }
}

