package com.vipicu.demo.security.resource.controller;

import com.vipicu.demo.db.entity.Authorities;
import com.vipicu.demo.db.service.AuthoritiesService;
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
