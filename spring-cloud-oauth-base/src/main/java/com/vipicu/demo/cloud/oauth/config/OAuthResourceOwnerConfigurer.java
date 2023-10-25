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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
public class OAuthResourceOwnerConfigurer {

    private final PermitAllUrlProperties permitAllUrlProperties;

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
        AntPathRequestMatcher[] requestMatchers = permitAllUrlProperties.getUrls()
                .stream()
                .map(AntPathRequestMatcher::new)
                .toList()
                .toArray(new AntPathRequestMatcher[] {});
        http.apply(securityCustomExtensionConfiguration);
        return http
                // 所有请求需要验证
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(requestMatchers).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2ResourceServer(resource -> resource
                        .opaqueToken(token -> token.introspector(opaqueTokenIntrospector))
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
