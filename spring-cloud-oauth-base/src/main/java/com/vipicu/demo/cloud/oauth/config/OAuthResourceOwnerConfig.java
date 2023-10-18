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
import com.vipicu.demo.cloud.oauth.utils.JwtSecretUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.HashSet;
import java.util.Set;

/**
 * Oauth资源所有者配置
 *
 * @author Administrator
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class OAuthResourceOwnerConfig {

    /**
     * security配置
     */
    private final SecurityProperties securityProperties;

    /**
     * 默认忽略url
     */
    private static final String[] DEFAULT_IGNORE_URLS = new String[]{"/actuator/**",
            "/error",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/doc.html",
            "/webjars/**"};


    @Bean
    @ConditionalOnMissingBean
    public SecurityCustomExtensionConfiguration securityCustomExtensionConfiguration(){
        return new SecurityCustomExtensionConfiguration();
    }

    @Bean
    public SecurityFilterChain resourceSecurityFilterChain(HttpSecurity http, SecurityCustomExtensionConfiguration securityCustomExtensionConfiguration) throws Exception {
        http.apply(securityCustomExtensionConfiguration);
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
        authoritiesConverter.setAuthoritiesClaimName("user_info");
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
        return http
                // 所有请求需要验证
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(DEFAULT_IGNORE_URLS).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2ResourceServer(resource -> resource
                        .jwt(jwt -> jwt.decoder(jwtDecoder(jwkSource())).jwtAuthenticationConverter(jwtAuthenticationConverter))
                        .bearerTokenResolver(bearerTokenResolver())
                )
                // .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }


    /**
     * 从request请求中那个地方获取到token
     */
    private BearerTokenResolver bearerTokenResolver() {
        DefaultBearerTokenResolver bearerTokenResolver = new DefaultBearerTokenResolver();
        // 设置请求头的参数，即从这个请求头中获取到token
        bearerTokenResolver.setBearerTokenHeaderName(HttpHeaders.AUTHORIZATION);
        bearerTokenResolver.setAllowFormEncodedBodyParameter(false);
        // 是否可以从uri请求参数中获取token
        bearerTokenResolver.setAllowUriQueryParameter(false);
        return bearerTokenResolver;
    }

    @Bean
    @SneakyThrows
    @ConditionalOnMissingBean
    public JWKSource<SecurityContext> jwkSource() {
        RSAPublicKey publicKey = JwtSecretUtils.readReaPublicKey(securityProperties.getPublicKey().getBytes(StandardCharsets.UTF_8));
        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .keyID(JwtSecretUtils.KEY_ID)
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
