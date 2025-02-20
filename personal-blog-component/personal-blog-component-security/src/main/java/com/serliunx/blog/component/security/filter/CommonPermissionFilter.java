package com.serliunx.blog.component.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 鉴权过滤器
 * <li> 主要用于权限校验
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/18
 */
@Slf4j
@Component
public final class CommonPermissionFilter extends AbstractCommonFilter implements InitializingBean {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    protected void execute(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

    }

    @Override
    protected boolean isEnabled() {
        return securityConfiguration.isEnableCommonPermissionFilter();
    }
}
