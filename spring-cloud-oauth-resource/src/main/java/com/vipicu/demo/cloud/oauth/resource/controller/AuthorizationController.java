package com.vipicu.demo.security.resource.controller;

import com.vipicu.demo.db.entity.Oauth2Authorization;
import com.vipicu.demo.db.service.Oauth2AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authorization")
public class AuthorizationController {

    private final Oauth2AuthorizationService  authorizationService;

    @GetMapping
    public List<Oauth2Authorization> fetchAuthorization() {
        return  authorizationService.list();
    }

}
