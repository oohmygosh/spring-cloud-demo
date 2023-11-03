package com.vipicu.demo.oauth.auth.support.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份验证成功处理程序
 *
 * @author Lee
 * @since 1.0.0
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final OAuth2AccessTokenResponseHttpMessageConverter accessTokenHttpResponseConverter = new OAuth2AccessTokenResponseHttpMessageConverter();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AccessTokenAuthenticationToken accessTokenAuthentication = (OAuth2AccessTokenAuthenticationToken) authentication;

        OAuth2AccessToken accessToken = accessTokenAuthentication.getAccessToken();
        OAuth2RefreshToken refreshToken = accessTokenAuthentication.getRefreshToken();
        Map<String, Object> additionalParameters = accessTokenAuthentication.getAdditionalParameters();
        SecurityContextHolder.getContext().setAuthentication(accessTokenAuthentication);
        OAuth2AccessTokenResponse.Builder builder = OAuth2AccessTokenResponse.withToken(accessToken.getTokenValue())
                .tokenType(accessToken.getTokenType())
                .scopes(accessToken.getScopes());
        if (accessToken.getIssuedAt() != null && accessToken.getExpiresAt() != null) {
            builder.expiresIn(ChronoUnit.SECONDS.between(accessToken.getIssuedAt(), accessToken.getExpiresAt()));
        }
        if (refreshToken != null) {
            builder.refreshToken(refreshToken.getTokenValue());
        }
        if (!CollectionUtils.isEmpty(additionalParameters)) {
            builder.additionalParameters(additionalParameters);
        }
        OAuth2AccessTokenResponse accessTokenResponse = builder.build();
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
        // 无状态 注意删除 context 上下文的信息
        SecurityContextHolder.clearContext();
        accessTokenHttpResponseConverter.setAccessTokenResponseParametersConverter(this::convert);
        accessTokenHttpResponseConverter.write(accessTokenResponse, MediaType.APPLICATION_JSON, httpResponse);
    }


    public Map<String, Object> convert(OAuth2AccessTokenResponse tokenResponse) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("accessToken", tokenResponse.getAccessToken().getTokenValue());
        parameters.put("tokenType", tokenResponse.getAccessToken().getTokenType().getValue());
        parameters.put("expiresIn", getExpiresIn(tokenResponse));
        if (!CollectionUtils.isEmpty(tokenResponse.getAccessToken().getScopes())) {
            parameters.put("scope", StringUtils.collectionToDelimitedString(tokenResponse.getAccessToken().getScopes(), " "));
        }

        if (tokenResponse.getRefreshToken() != null) {
            parameters.put("refreshToken", tokenResponse.getRefreshToken().getTokenValue());
        }

        if (!CollectionUtils.isEmpty(tokenResponse.getAdditionalParameters())) {
            parameters.putAll(tokenResponse.getAdditionalParameters());
        }

        return parameters;
    }

    private static long getExpiresIn(OAuth2AccessTokenResponse tokenResponse) {
        return tokenResponse.getAccessToken().getExpiresAt() != null ? ChronoUnit.SECONDS.between(Instant.now(), tokenResponse.getAccessToken().getExpiresAt()) : -1L;
    }

}
