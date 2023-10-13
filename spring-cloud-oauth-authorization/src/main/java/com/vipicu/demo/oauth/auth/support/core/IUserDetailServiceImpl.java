package com.vipicu.demo.oauth.auth.support.core;

import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import com.vipicu.demo.cloud.db.h2.service.ISysUserService;
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

    private final ISysUserService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = usersService.lambdaQuery().eq(SysUser::getUsername, username).one();
        Assert.notNull(user, "不存在用户！");
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList("admin");
        return new IUserDetails(user.getUsername(),
                "{bcrypt}" + user.getPassword(),
                true,
                true,
                true,
                user.getStatus() == 1,
                authorities);
    }
}
