package com.vipicu.demo.cloud.service.resource03.api.feign;

import com.vipicu.demo.cloud.core.constant.SecurityConstants;
import com.vipicu.demo.cloud.core.entity.ApiResult;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "remoteUserService", value = "spring-cloud-service-resource03-app")
public interface RemoteUserService {

    @GetMapping("/user/userInfo")
    ApiResult<UserInfo> fetchUserInfo(@RequestParam("username") String username, @RequestHeader(SecurityConstants.FROM) String from);

}
