package com.vipicu.demo.cloud.service.resource01.controller;

import com.vipicu.demo.cloud.db.h2.entity.Oauth2RegisteredClient;
import com.vipicu.demo.cloud.db.h2.service.Oauth2RegisteredClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@Tag(name = "客户端管理", description = "客户端管理")
public class ClientController {

    private final Oauth2RegisteredClientService clientService;

    @GetMapping
    @Operation(summary = "获取客户端列表")
    public List<Oauth2RegisteredClient> fetchClients() {
        return clientService.list();
    }

}
