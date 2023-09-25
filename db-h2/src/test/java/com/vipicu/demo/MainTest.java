package com.vipicu.demo.coud.db;


import com.vipicu.demo.cloud.db.h2.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * SpringBoot Start测试
 *
 * @author Lee
 * @since 1.0.0
 */
@SpringBootTest
@ComponentScans(
        value = {
                @ComponentScan("com.vipicu.*")
        }
)
public class MainTest {

    @Autowired
    UsersService usersService;

    @Test
    public void test(){
        System.out.println(usersService.list());
    }

}
