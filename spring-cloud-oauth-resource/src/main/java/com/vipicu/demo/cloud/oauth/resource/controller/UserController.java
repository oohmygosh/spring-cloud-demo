package com.vipicu.demo.cloud.oauth.resource.controller;

import com.vipicu.demo.cloud.db.h2.entity.Users;
import com.vipicu.demo.cloud.db.h2.service.UsersService;
import com.vipicu.demo.cloud.oauth.resource.entity.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "用户")
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

    @GetMapping("/all")
    @Operation(summary = "获取所有用户")
    public List<Users> fetchAllUsers() {
        return usersService.list();
    }

    @GetMapping("/obj")
    @Operation(summary = "obj")
    public List<Users> obj() {
        return usersService.list();
    }

    @GetMapping("/all1")
    @Operation(summary = "获取所有用户1")
    public ApiResult<List<Users>> fetchAllUsers1() {
        return ApiResult.result(usersService.list(), 200 , "xxx");
    }

    @GetMapping("/map")
    @Operation(summary = "map")
    public Map<String, Object> fetchMap() {
        return new HashMap<>() {{
            put("code", usersService.list());
        }};
    }

}
