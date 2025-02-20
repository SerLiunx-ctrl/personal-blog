package com.serliunx.blog.component.security.validator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 安全校验器上下文： 负责校验器的调度及注册
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/19
 * @see SecurityValidator
 * @see SecurityValidatorRegistry
 */
@Component
public final class SecurityValidatorContext implements ApplicationContextAware, InitializingBean {

    /**
     * 容器
     */
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {

        // 从配置器中加载安全校验器
        configurerValidator();

        // 直接从容器中加载安全校验器
        directInitFromApplicationContext();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 直接从容器中加载安全校验器
     */
    private void directInitFromApplicationContext() {
        // TODO 注册逻辑
    }

    /**
     * 配置校验器
     */
    private void configurerValidator() {
        final Map<String, SecurityValidatorConfigurer> configurer =
                applicationContext.getBeansOfType(SecurityValidatorConfigurer.class);
        if (configurer.isEmpty()) {
            return;
        }
        final SecurityValidatorRegistry registry = new SecurityValidatorRegistry(this);
        configurer.forEach((k, v) -> v.configurer(registry));
    }
}
