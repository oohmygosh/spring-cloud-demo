package com.vipicu.demo;


import com.vipicu.demo.cloud.db.h2.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot Start测试
 *
 * @author Lee
 * @since 1.0.0
 */
@SpringBootTest
public class MainTest {

    @Autowired
    UsersService usersService;

    @Test
    public void test(){
        System.out.println(usersService.list());
    }

}
