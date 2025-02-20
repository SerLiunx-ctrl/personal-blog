package com.serliunx.blog.component.security.validator;

/**
 * 安全校验配置器
 * <li> 实现此接口来配置及注册安全校验器
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/19
 */
@FunctionalInterface
public interface SecurityValidatorConfigurer {

    /**
     * 配置校验器
     */
    void configurer(SecurityValidatorRegistry registry);
}
