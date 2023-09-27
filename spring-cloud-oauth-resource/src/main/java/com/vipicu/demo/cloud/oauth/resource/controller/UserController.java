package com.vipicu.demo.cloud.oauth.resource.controller;

import com.vipicu.demo.cloud.db.h2.entity.Users;
import com.vipicu.demo.cloud.db.h2.service.UsersService;
import com.vipicu.demo.cloud.oauth.resource.entity.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "用户管理")
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

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

}
