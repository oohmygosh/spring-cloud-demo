package com.vipicu.demo.oauth.auth.support.core;

import com.vipicu.demo.cloud.core.constant.CacheConstants;
import com.vipicu.demo.cloud.db.h2.entity.SysRole;
import com.vipicu.demo.cloud.db.h2.entity.SysUser;
import com.vipicu.demo.cloud.db.h2.mapper.SysResourceApiMapper;
import com.vipicu.demo.cloud.db.h2.mapper.SysRoleMapper;
import com.vipicu.demo.cloud.db.h2.service.SysUserService;
import com.vipicu.demo.cloud.oauth.entity.IUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// @Service
@AllArgsConstructor
public class IUserDetailServiceImpl implements UserDetailsService {

    private final SysUserService usersService;
    private final SysRoleMapper roleMapper;
    private final SysResourceApiMapper sysResourceApiMapper;

    @Override
    @Cacheable(value = CacheConstants.USER_DETAILS, key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = usersService.lambdaQuery().eq(SysUser::getUsername, username).one();
        Assert.notNull(user, "不存在用户！");
        List<SysRole> roleByUserId = roleMapper.getRoleByUserId(user.getId());
        HashSet<String> auths = new HashSet<>();
        auths.addAll(roleByUserId.stream().map(SysRole::getAlias).map("ROLE_"::concat).toList());
        auths.addAll(sysResourceApiMapper.selectCodesByUserId(user.getId()));
        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(auths.toArray(new String[0]));
        return new IUserDetails(user.getUsername(),
                "{bcrypt}" + user.getPassword(),
                true,
                true,
                true,
                user.getStatus() == 1,
                authorities);
    }
}
