package com.vipicu.demo.cloud.oauth.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Oauth资源所有者配置
 *
 * @author Administrator
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class OAuthResourceOwnerConfig {


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


    private final OpaqueTokenIntrospector opaqueTokenIntrospector;
    @Bean
    @ConditionalOnMissingBean
    public CustomExtensionConfigurer securityCustomExtensionConfiguration(){
        return new CustomExtensionConfigurer() {
            @Override
            public void init(HttpSecurity builder) throws Exception {
                super.init(builder);
            }
        };
    }

    @Bean
    public SecurityFilterChain resourceSecurityFilterChain(HttpSecurity http,
                                                           CustomExtensionConfigurer securityCustomExtensionConfiguration
    ) throws Exception {
        http.apply(securityCustomExtensionConfiguration);
        // JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        // jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtGrantedAuthoritiesConverter());
        return http
                // 所有请求需要验证
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(DEFAULT_IGNORE_URLS).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2ResourceServer(resource -> resource
                        .opaqueToken(token -> token.introspector(opaqueTokenIntrospector))
                        // .jwt(jwt -> jwt.decoder(jwtDecoder).jwtAuthenticationConverter(jwtAuthenticationConverter))
                        .bearerTokenResolver(bearerTokenResolver())
                )
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

}
