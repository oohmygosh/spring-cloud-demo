package com.vipicu.demo.cloud.service.resource01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringCloudResource01ApplicationTest {


    @Test
    public void test(){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        PasswordEncoder bCryptPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.matches("admin", encoder.encode("admin")));
        System.out.println(bCryptPasswordEncoder.matches("admin", encoder.encode("admin")));
        System.out.println(bCryptPasswordEncoder.matches("admin", encoder.encode("admin")));
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }

}