package com.serliunx.blog.component.security.filter;

import com.serliunx.blog.component.security.config.SecurityConfiguration;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import java.io.IOException;

/**
 * 通用的抽象过滤器, 定义通用逻辑: 上下文获取、过滤器顺序定义、是否启用等.
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/18
 */
public abstract class AbstractCommonFilter implements Ordered, Filter, ApplicationContextAware {

    @Resource
    protected SecurityConfiguration securityConfiguration;

    /**
     * 应用上下文, 子类使用
     */
    protected ApplicationContext applicationContext;

    @Override
    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if (isEnabled()) {
            execute(servletRequest, servletResponse, filterChain);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 过滤器校验逻辑, 交由子类实现
     */
    protected abstract void execute(ServletRequest servletRequest, ServletResponse servletResponse,
                                       FilterChain filterChain);

    /**
     * 校验过滤器是否启用
     *
     * @return  启用返回真, 否则返回假
     */
    protected boolean isEnabled() {
        return true;
    }
}
