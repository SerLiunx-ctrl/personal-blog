package com.serliunx.blog.component.util.web;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP接口端点上下文
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/18
 */
@Slf4j
@Component
public final class RestEndpointContext implements InitializingBean, ApplicationContextAware {

    /**
     * Spring应用上下文
     */
    private ApplicationContext applicationContext;

    @Getter
    private final Map<String, HandlerMethod> stringHandlerMethodMap = new HashMap<>(256);

    /**
     * 匹配端点处理器
     *
     * @param path  路径
     */
    @Nullable
    public HandlerMethod matchHandlerMethod(String path) {
        return stringHandlerMethodMap.get(path);
    }

    @Override
    public void afterPropertiesSet() {
        final RequestMappingHandlerMapping mappingHandlerMappingBean =
                applicationContext.getBean(RequestMappingHandlerMapping.class);
        final Map<RequestMappingInfo, HandlerMethod> handlerMethodsMap = mappingHandlerMappingBean.getHandlerMethods();

        // 获取所有接口端点并尝试缓存
        handlerMethodsMap.forEach((k, v) -> {
            for (String directPath : k.getDirectPaths()) {
                stringHandlerMethodMap.put(directPath, v);
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
