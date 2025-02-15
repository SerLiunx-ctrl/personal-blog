package com.serliunx.blog.component.util.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通用配置信息(管理端、博客端通用)
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/2
 */
@Getter
@Setter
@Component
@ConfigurationProperties("blog-common")
public class CommonConfiguration {

	/**
	 * 是否输出业务异常信息
	 */
	private boolean outputServiceException = true;
}
