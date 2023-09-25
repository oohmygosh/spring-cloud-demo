package com.vipicu.demo.oauth.auth.impl;

import com.vipicu.demo.cloud.db.h2.entity.Users;
import com.vipicu.demo.cloud.db.h2.service.UsersService;
import com.vipicu.demo.oauth.auth.entity.IUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

@Service
@AllArgsConstructor
public class IUserDetailServiceImpl implements UserDetailsService {

    private final UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersService.lambdaQuery().eq(Users::getUsername, username).one();
        Assert.notNull(users, "不存在用户！");
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList("admin");
        return new IUserDetails(users.getUsername(),  "{bcrypt}" + users.getPassword(), authorities);
    }
}
