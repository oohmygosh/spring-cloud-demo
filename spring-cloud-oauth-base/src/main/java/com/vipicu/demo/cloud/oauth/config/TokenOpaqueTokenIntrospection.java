package com.vipicu.demo.cloud.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

import java.util.List;

@RequiredArgsConstructor
public class TokenOpaqueTokenIntrospection implements OpaqueTokenIntrospector {

    private final JwtDecoder jwtDecoder;
    private final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        Jwt jwt = jwtDecoder.decode(token);
        AbstractAuthenticationToken convert = jwtAuthenticationConverter.convert(jwt);
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("admin");
        authorities.addAll(convert.getAuthorities());
        return new OAuth2IntrospectionAuthenticatedPrincipal(jwt.getClaims(), authorities);
    }
}
