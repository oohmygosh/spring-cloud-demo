package com.vipicu.demo.cloud.oauth.service;

import com.vipicu.demo.cloud.core.constant.CacheConstants;
import com.vipicu.demo.cloud.core.constant.SecurityConstants;
import com.vipicu.demo.cloud.core.entity.ApiResult;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import com.vipicu.demo.cloud.service.resource03.api.feign.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class PwdUserDetailsService implements IUserDetailsService {

        private final RemoteUserService userService;

        @Override
        @Cacheable(value = CacheConstants.USER_DETAILS, key = "#username")
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiResult<UserInfo> userInfoApiResult = userService.fetchUserInfo(username, SecurityConstants.FROM_IN);
        UserInfo userInfo = userInfoApiResult.getData();
        return convert(userInfo);
    }

}
