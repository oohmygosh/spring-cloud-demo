package com.vipicu.demo.cloud.service.resource03.app.controller;

import com.vipicu.demo.cloud.service.resource03.api.entity.SysUser;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import com.vipicu.demo.cloud.service.resource03.app.service.ISysUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户")
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final ISysUserService userService;
    @GetMapping("/userInfo")
    public UserInfo fetchUserInfoByUsername(String username) {
        SysUser user = userService.lambdaQuery().eq(SysUser::getUsername, username).one();
        Assert.notNull(user, "用户不存在！");
        return userService.fetchUserInfo(user);
    }

}
