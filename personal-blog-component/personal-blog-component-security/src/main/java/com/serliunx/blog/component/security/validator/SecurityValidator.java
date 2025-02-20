package com.serliunx.blog.component.security.validator;

import org.springframework.core.Ordered;

/**
 *
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/19
 */
public interface SecurityValidator extends Ordered {

    @Override
    default int getOrder() {
        return 0;
    }
}
