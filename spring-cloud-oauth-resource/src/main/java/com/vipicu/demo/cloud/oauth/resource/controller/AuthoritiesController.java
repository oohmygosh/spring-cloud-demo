package com.vipicu.demo.cloud.oauth.resource.controller;

import com.vipicu.demo.cloud.db.h2.entity.Authorities;
import com.vipicu.demo.cloud.db.h2.service.AuthoritiesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 当局控制器
 *
 * @author Lee
 * @since 1.0.0
 */

@RestController
@AllArgsConstructor
@RequestMapping("/authorities")
public class AuthoritiesController {

    private final AuthoritiesService authoritiesService;

    @GetMapping
    public List<Authorities> fetchAuthorization() {
        return  authoritiesService.list();
    }

}
