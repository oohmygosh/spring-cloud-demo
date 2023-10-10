package com.vipicu.demo.cloud.service.resource01.controller;

import com.vipicu.demo.cloud.db.h2.entity.Users;
import com.vipicu.demo.cloud.db.h2.service.UsersService;
import com.vipicu.demo.cloud.service.resource01.feign.RemoteTestService;
import com.vipicu.demo.service.entity.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "用户管理")
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;
    private final RemoteTestService testService;

    @GetMapping("/all")
    @Operation(summary = "获取所有用户")
    public List<Users> fetchAllUsers() {
        return usersService.list();
    }

    @GetMapping
    @Operation(summary = "获取当前用户")
    public Authentication fetchCurUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PutMapping
    @Operation(summary = "測試")
    public ApiResult<String> test() {
        return testService.test();
    }

}