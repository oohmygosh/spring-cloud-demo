package com.vipicu.demo.cloud.oauth.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class OAuth2RequestInterceptor implements RequestInterceptor {

	private final BearerTokenResolver tokenResolver;

	@Override
	public void apply(RequestTemplate template) {
		// 非web 请求直接跳过
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (Optional.ofNullable(requestAttributes).isEmpty()) {
			return;
		}
        HttpServletRequest request = requestAttributes.getRequest();
		// 避免请求参数的 query token 无法传递
		String token = tokenResolver.resolve(request);
		if (!StringUtils.hasLength(token)) {
			return;
		}
		template.header(HttpHeaders.AUTHORIZATION,
				String.format("%s %s", OAuth2AccessToken.TokenType.BEARER.getValue(), token));

	}

}
