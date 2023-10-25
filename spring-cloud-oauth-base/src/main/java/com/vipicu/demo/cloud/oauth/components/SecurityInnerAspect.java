package com.vipicu.demo.cloud.oauth.components;

import com.vipicu.demo.cloud.core.constant.SecurityConstants;
import com.vipicu.demo.cloud.oauth.annotations.Inner;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;

import java.nio.file.AccessDeniedException;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class SecurityInnerAspect implements Ordered {

    private final HttpServletRequest request;
    @Around("@annotation(inner)")
    public Object around(ProceedingJoinPoint point, Inner inner) throws Throwable {
        // 实际注入的inner实体由表达式后一个注解决定，即是方法上的@Inner注解实体，若方法上无@Inner注解，则获取类上的
        if (inner == null) {
            Class<?> clazz = point.getTarget().getClass();
            inner = AnnotationUtils.findAnnotation(clazz, Inner.class);
        }
        String header = request.getHeader(SecurityConstants.FROM);
        if (inner != null && inner.value() && !SecurityConstants.FROM_IN.equalsIgnoreCase(header)){
            log.warn("访问接口 {} 没有权限", point.getSignature().getName());
            throw new AccessDeniedException("Access is denied");
        }
        return point.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
