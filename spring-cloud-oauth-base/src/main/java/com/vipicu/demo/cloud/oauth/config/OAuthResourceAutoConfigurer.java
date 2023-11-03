package com.vipicu.demo.cloud.oauth.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import com.vipicu.demo.cloud.oauth.components.TokenOpaqueTokenIntrospection;
import com.vipicu.demo.cloud.oauth.utils.JwtSecretUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @since 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class OAuthResourceAutoConfigurer {

    /**
     * security配置
     */
    private final SecurityProperties securityProperties;

    @Bean
    public OpaqueTokenIntrospector customOpaqueTokenIntrospector(JwtDecoder jwtDecoder, UserDetailsService userDetailsService){
        return new TokenOpaqueTokenIntrospection(jwtDecoder, userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @SneakyThrows
    @ConditionalOnMissingBean
    public JWKSource<SecurityContext> jwkSource() {
        RSAPublicKey publicKey = JwtSecretUtils.readReaPublicKey(securityProperties.getPublicKey().getBytes(StandardCharsets.UTF_8));
        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .keyID("f2d4da56-849e-404b-993b-1d966db67237")
                .build();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return new ImmutableJWKSet<>(jwkSet);
    }

    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
        Set<JWSAlgorithm> jwsAlgorithm = new HashSet<>();
        jwsAlgorithm.addAll(JWSAlgorithm.Family.RSA);
        jwsAlgorithm.addAll(JWSAlgorithm.Family.EC);
        jwsAlgorithm.addAll(JWSAlgorithm.Family.HMAC_SHA);
        ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
        JWSKeySelector<SecurityContext> jwsKeySelector =
                new JWSVerificationKeySelector<>(jwsAlgorithm, jwkSource);
        jwtProcessor.setJWSKeySelector(jwsKeySelector);
        // Override the default Nimbus claims set verifier as NimbusJwtDecoder handles it instead
        jwtProcessor.setJWTClaimsSetVerifier((claims, context) -> {
        });
        return new NimbusJwtDecoder(jwtProcessor);
    }

}
