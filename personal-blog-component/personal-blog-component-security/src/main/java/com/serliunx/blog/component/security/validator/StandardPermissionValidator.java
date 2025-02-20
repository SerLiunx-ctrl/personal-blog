package com.serliunx.blog.component.security.validator;

/**
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/19
 */
public class StandardPermissionValidator implements SecurityValidator {

    @Override
    public int getOrder() {
        return 1;
    }
}
