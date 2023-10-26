package com.vipicu.demo.cloud.service.resource01.controller;

import com.vipicu.demo.cloud.db.sqlite.entity.Authorities;
import com.vipicu.demo.cloud.db.sqlite.service.AuthoritiesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "授权管理")
public class AuthoritiesController {

    private final AuthoritiesService authoritiesService;

    @GetMapping
    @Operation(summary = "获取所有权限")
    public List<Authorities> fetchAuthorization() {
        return  authoritiesService.list();
    }

}
