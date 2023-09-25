package com.vipicu.demo.security.resource.controller;

import com.vipicu.demo.db.entity.Oauth2RegisteredClient;
import com.vipicu.demo.db.service.Oauth2RegisteredClientService;
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
