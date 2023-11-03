package com.vipicu.demo.cloud.oauth.components;

import com.vipicu.demo.cloud.oauth.entity.IUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.BadJwtException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.util.Assert;

@Slf4j
@RequiredArgsConstructor
public class TokenOpaqueTokenIntrospection implements OpaqueTokenIntrospector {

    private final JwtDecoder jwtDecoder;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        try {
            Jwt jwt = this.jwtDecoder.decode(token);
            AbstractAuthenticationToken convert = jwtAuthenticationConverter.convert(jwt);
            IUserDetails userDetails = (IUserDetails) userDetailsService.loadUserByUsername(convert.getName());
            Assert.notNull(userDetails, "缓存过期");
            return userDetails;
        } catch (BadJwtException var3) {
            log.debug("Failed to authenticate since the JWT was invalid");
            throw new InvalidBearerTokenException(var3.getMessage(), var3);
        } catch (JwtException var4) {
            throw new AuthenticationServiceException(var4.getMessage(), var4);
        }
    }
}
