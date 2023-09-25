package com.vipicu.demo.support.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * 自定义身份验证失败处理程序
 *
 * @author Lee
 * @since 1.0.0
 */
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final MappingJackson2HttpMessageConverter accessTokenHttpResponseConverter = new MappingJackson2HttpMessageConverter();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
        httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        String username = request.getParameter(OAuth2ParameterNames.USERNAME);
        log.error("用户：{} 登录失败，异常：{}", username, exception.getLocalizedMessage());
        this.accessTokenHttpResponseConverter.write(exception.getLocalizedMessage(), MediaType.APPLICATION_JSON, httpResponse);
    }

}
