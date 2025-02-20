package com.serliunx.blog.component.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 安全模块通用配置信息
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/18
 */
@Data
@Component
@ConfigurationProperties("blog-security")
public class SecurityConfiguration {

    /**
     * 是否启用身份认证过滤器
     * <li> 关闭时, 不校验用户是否登录
     * <li> !!!建议尽在测试环境中关闭
     */
    private boolean enableAuthenticationFilter = true;

    /**
     * 是否启用鉴权过滤器
     * <li> 关闭时, 不校验用户是否拥有指定接口的权限
     * <li> !!!此过滤器优先级低于身份认证过滤器, 当关闭身份认证时, 此过滤器自动关闭
     * <li> !!!建议尽在测试环境中关闭
     */
    private boolean enableCommonPermissionFilter = true;
}
