package com.vipicu.demo.oauth.auth.support.core;

import com.vipicu.demo.cloud.db.h2.entity.SysRole;
import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import com.vipicu.demo.cloud.db.h2.mapper.SysResourceApiMapper;
import com.vipicu.demo.cloud.db.h2.mapper.SysRoleMapper;
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
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class IUserDetailServiceImpl implements UserDetailsService {

    private final ISysUserService usersService;
    private final SysRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = usersService.lambdaQuery().eq(SysUser::getUsername, username).one();
        Assert.notNull(user, "不存在用户！");
        List<SysRole> roleByUserId = roleMapper.getRoleByUserId(user.getId());
        List<String> roles;
        if (!CollectionUtils.isEmpty(roleByUserId))
            roles = roleByUserId.stream().map(SysRole::getAlias).map("ROLE_"::concat).toList();
        else
            roles = Collections.emptyList();
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(roles.toArray(new String[0]));
        return new IUserDetails(user.getUsername(),
                "{bcrypt}" + user.getPassword(),
                true,
                true,
                true,
                user.getStatus() == 1,
                authorities);
    }
}
