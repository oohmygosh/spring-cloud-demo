package com.vipicu.demo.oauth.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

public class IUserDetails extends User implements Serializable {

    public IUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    /**
     * 国际单位详细信息
     *
     * @param username              用户名
     * @param password              密码
     * @param enabled               启用
     * @param accountNonExpired     帐户未过期
     * @param credentialsNonExpired 证书未过期
     * @param accountNonLocked      帐号未锁定
     * @param authorities           当局
     */
    public IUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
