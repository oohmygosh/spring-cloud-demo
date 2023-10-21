package com.vipicu.demo.cloud.service.resource01.controller;

import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import com.vipicu.demo.cloud.db.h2.service.ISysUserService;
import com.vipicu.demo.cloud.service.resource01.feign.RemoteTestService;
import com.vipicu.demo.service.entity.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "用户管理")
@RequestMapping("/user")
public class UserController {

    private final RemoteTestService testService;
    private final ISysUserService userService;

    @GetMapping("/all")
    @Operation(summary = "获取所有用户")
    public List<SysUser> fetchAllUsers() {
        return userService.list();
    }

    @GetMapping
    @Operation(summary = "获取当前用户")
    @PreAuthorize("hasAuthority('admin')")
    public Authentication fetchCurUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PutMapping
    @Operation(summary = "測試")
    public ApiResult<String> test() {
        return testService.test();
    }

}
