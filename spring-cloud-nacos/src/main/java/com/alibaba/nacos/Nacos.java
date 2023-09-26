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
        // 单机模式
        System.setProperty("nacos.standalone", "true");
        // 是否开启鉴权
        System.setProperty("nacos.core.auth.enabled", "true");
        // 日志位置
        System.setProperty("server.tomcat.basedir", "logs");
        // 日志
        System.setProperty("server.tomcat.accesslog.enabled", "false");
        return true;
    }
}

