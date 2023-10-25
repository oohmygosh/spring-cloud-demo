package com.vipicu.demo.cloud.oauth.components;

import com.vipicu.demo.cloud.core.constant.CacheConstants;
import com.vipicu.demo.cloud.oauth.entity.IUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.BadJwtException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TokenOpaqueTokenIntrospection implements OpaqueTokenIntrospector {

    private final JwtDecoder jwtDecoder;
    private final CacheManager cacheManager;
    private final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        try {
            Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
            Assert.notNull(cache, "请检查缓存!");
            Jwt jwt = this.jwtDecoder.decode(token);
            AbstractAuthenticationToken convert = jwtAuthenticationConverter.convert(jwt);
            IUserDetails userDetails = cache.get(convert.getName(), IUserDetails.class);
            Assert.notNull(userDetails, "缓存过期");
            ArrayList<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
            authorities.addAll(convert.getAuthorities());
            return new OAuth2IntrospectionAuthenticatedPrincipal(convert.getName(), jwt.getClaims(), authorities);
        } catch (BadJwtException var3) {
            log.debug("Failed to authenticate since the JWT was invalid");
            throw new InvalidBearerTokenException(var3.getMessage(), var3);
        } catch (JwtException var4) {
            throw new AuthenticationServiceException(var4.getMessage(), var4);
        }
    }
}
