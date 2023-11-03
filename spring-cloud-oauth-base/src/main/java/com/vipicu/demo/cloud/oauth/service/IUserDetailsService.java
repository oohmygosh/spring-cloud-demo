package com.vipicu.demo.cloud.oauth.service;

import com.vipicu.demo.cloud.oauth.entity.IUserDetails;
import com.vipicu.demo.cloud.service.resource03.api.entity.SysUser;
import com.vipicu.demo.cloud.service.resource03.api.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;

public interface IUserDetailsService extends UserDetailsService {

    default UserDetails convert(UserInfo userInfo) {
        Collection<String> auths = new HashSet<>();
        auths.addAll(userInfo.getAuthorities());
        auths.addAll(userInfo.getRoles().stream().map("ROLE_"::concat).toList());
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(auths.toArray(new String[0]));
        SysUser sysUser = userInfo.getSysUser();
        return new IUserDetails(
                sysUser.getPhone(),
                sysUser.getId(),
                sysUser.getUsername(),
                "{bcrypt}" + sysUser.getPassword(),
                true,
                true,
                true,
                sysUser.getStatus() == 1,
                authorities);
    }

}
