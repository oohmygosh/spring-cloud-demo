package com.vipicu.demo.cloud.oauth.resource.controller;

import com.vipicu.demo.cloud.db.h2.entity.Oauth2RegisteredClient;
import com.vipicu.demo.cloud.db.h2.service.Oauth2RegisteredClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final Oauth2RegisteredClientService clientService;

    @GetMapping
    public List<Oauth2RegisteredClient> fetchClients() {
        return clientService.list();
    }

}
