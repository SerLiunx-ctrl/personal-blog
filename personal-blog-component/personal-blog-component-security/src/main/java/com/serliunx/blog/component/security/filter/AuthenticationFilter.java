package com.serliunx.blog.component.security.filter;

import com.serliunx.blog.component.util.exception.ServiceException;
import com.serliunx.blog.component.util.web.RestEndpointContext;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

/**
 * 身份认证过滤器
 * <li> 主要用于用户的身份认证
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/18
 */
@Slf4j
@Component
public final class AuthenticationFilter extends AbstractCommonFilter {

    @Resource
    private RestEndpointContext restEndpointContext;

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    protected void execute(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        if (servletRequest instanceof HttpServletRequest httpServletRequest) {
            String contextPath = httpServletRequest.getContextPath();
            HandlerMethod handlerMethod = restEndpointContext.matchHandlerMethod(httpServletRequest.getRequestURI()
                    .replaceFirst(contextPath, ""));
            if (handlerMethod == null) {
                return;
            }
        } else {
            throw new ServiceException("系统异常, 请联系管理员", 99999);
        }
    }

    @Override
    protected boolean isEnabled() {
        return securityConfiguration.isEnableAuthenticationFilter();
    }
}
