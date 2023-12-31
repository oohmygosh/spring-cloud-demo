package com.vipicu.demo.oauth.auth.support.base;

import com.vipicu.demo.oauth.auth.utils.OAuth2EndpointUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义oauth2资源所有者基础身份验证转换器
 *
 * @author Lee
 * @since 1.0.0
 */
public abstract class CustomOAuth2AuthenticationConverter<T extends OAuth2ResourceOwnerBaseAuthenticationToken> implements AuthenticationConverter {

    /**
     * 支持
     *
     * @param grantType 授权类型
     * @return boolean
     */
    public abstract boolean support(String grantType);

    /**
     * 检查参数
     *
     * @param request 请求
     */
    public void checkParams(HttpServletRequest request) {
    }


    public abstract T buildToken(Authentication clientPrincipal, Set<String> requestedScopes,
                                 Map<String, Object> additionalParameters);

    /**
     * 转换
     *
     * @param request 请求
     * @return {@link Authentication}
     */
    @Override
    public T convert(HttpServletRequest request) {

        String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
        if (!support(grantType))
            return null;
        MultiValueMap<String, String> parameters = OAuth2EndpointUtils.getParameters(request);
        String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
        if (StringUtils.hasText(scope) && parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
            OAuth2EndpointUtils.throwError(OAuth2ErrorCodes.INVALID_REQUEST, OAuth2ParameterNames.SCOPE,
                    OAuth2EndpointUtils.ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        Set<String> requestedScopes = null;
        if (StringUtils.hasText(scope)) {
            requestedScopes = new HashSet<>(Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
        }

        // 校验个性化参数
        checkParams(request);

        // 获取当前已经认证的客户端信息
        Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();
        if (clientPrincipal == null) {
            OAuth2EndpointUtils.throwError(OAuth2ErrorCodes.INVALID_REQUEST, OAuth2ErrorCodes.INVALID_CLIENT,
                    OAuth2EndpointUtils.ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        // 扩展信息
        Map<String, Object> additionalParameters = parameters.entrySet()
                .stream()
                .filter(e -> !e.getKey().equals(OAuth2ParameterNames.GRANT_TYPE)
                        && !e.getKey().equals(OAuth2ParameterNames.SCOPE))
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get(0)));

        return buildToken(clientPrincipal, requestedScopes, additionalParameters);
    }


}
