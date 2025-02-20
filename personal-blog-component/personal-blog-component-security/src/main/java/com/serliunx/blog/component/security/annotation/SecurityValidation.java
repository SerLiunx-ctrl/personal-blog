package com.serliunx.blog.component.security.annotation;

import com.serliunx.blog.component.security.validator.SecurityValidator;

import java.lang.annotation.*;

/**
 * 安全校验注解
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SecurityValidations.class)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SecurityValidation {

    /**
     * 指定使用的校验器组别
     */
    Class<?> value() default Void.class;

    /**
     * 手动指定校验器
     * <li>
     */
    Class<? extends SecurityValidator> validator() default SecurityValidator.class;

    /**
     * 校验器来源
     */
    enum ValidatorSource {

        APPLICATION_CONTEXT,

        CLASS_LOADER;
    }
}
