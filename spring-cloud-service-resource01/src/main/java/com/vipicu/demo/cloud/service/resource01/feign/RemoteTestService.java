package com.vipicu.demo.cloud.service.resource01.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "remoteTestService", value = "spring-cloud-service-resource02")
public interface RemoteTestService {

    @GetMapping("/test")
    String test();

}
