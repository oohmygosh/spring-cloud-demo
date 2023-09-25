package com.vipicu.demo.cloud.oauth.resource.controller;

import com.vipicu.demo.cloud.db.h2.entity.Oauth2Authorization;
import com.vipicu.demo.cloud.db.h2.service.Oauth2AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authorization")
public class AuthorizationController {

    private final Oauth2AuthorizationService authorizationService;

    @GetMapping
    public List<Oauth2Authorization> fetchAuthorization() {
        return  authorizationService.list();
    }

}
