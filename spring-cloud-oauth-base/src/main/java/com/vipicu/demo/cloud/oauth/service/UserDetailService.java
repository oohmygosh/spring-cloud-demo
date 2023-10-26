package com.vipicu.demo.cloud.oauth.service;

import com.vipicu.demo.cloud.core.constant.CacheConstants;
import com.vipicu.demo.cloud.core.constant.SecurityConstants;
import com.vipicu.demo.cloud.core.entity.ApiResult;
import com.vipicu.demo.cloud.oauth.entity.IUserDetails;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import com.vipicu.demo.cloud.service.resource03.api.feign.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;

@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final RemoteUserService userService;

    @Override
    @Cacheable(value = CacheConstants.USER_DETAILS, key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiResult<UserInfo> userInfoApiResult = userService.fetchUserInfo(username, SecurityConstants.FROM_IN);
        UserInfo userInfo = userInfoApiResult.getData();
        Collection<String> auths = new HashSet<>();
        auths.addAll(userInfo.getAuthorities());
        auths.addAll(userInfo.getRoles().stream().map("ROLE_"::concat).toList());
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(auths.toArray(new String[0]));
        return new IUserDetails(
                userInfo.getSysUser().getUsername(),
                "{bcrypt}" + userInfo.getSysUser().getPassword(),
                userInfo.getSysUser().getDeleted() == 0,
                true,
                true,
                userInfo.getSysUser().getStatus() == 1,
                authorities
        );
    }
}
