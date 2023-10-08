package com.vipicu.demo.cloud.service.resource01.controller;

import com.vipicu.demo.cloud.db.h2.entity.Oauth2Authorization;
import com.vipicu.demo.cloud.db.h2.service.Oauth2AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authorization")
@Tag(name = "Authorization", description = "授权相关接口")
public class AuthorizationController {

    private final Oauth2AuthorizationService authorizationService;

    @GetMapping
    @Operation(summary = "获取授权信息")
    public List<Oauth2Authorization> fetchAuthorization() {
        return  authorizationService.list();
    }

}
