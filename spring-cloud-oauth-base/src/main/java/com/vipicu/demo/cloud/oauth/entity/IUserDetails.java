package com.vipicu.demo.cloud.oauth.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IUserDetails extends User implements OAuth2AuthenticatedPrincipal {

    @Getter
    private Long id;
    @Getter
    private String phone;
    private final Map<String, Object> attributes = new HashMap<>();

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
    public IUserDetails(String phone,Long id,String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.phone = phone;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public String getName() {
        return getUsername();
    }
}
