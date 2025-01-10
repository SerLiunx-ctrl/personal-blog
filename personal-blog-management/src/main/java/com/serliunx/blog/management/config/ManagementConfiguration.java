package com.serliunx.blog.management.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 管理后台参数配置
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/5
 */
@Getter
@Setter
@Component
@ConfigurationProperties("management")
public class ManagementConfiguration {

	/**
	 * 用户管理相关
	 */
	private User user;

	@Data
	public static class User {
		/**
		 * 用户名最大长度
		 */
		private int usernameMaxLength = 20;
		/**
		 * 用户名最小长度
		 */
		private int usernameMinLength = 4;
		/**
		 * 密码最大长度
		 */
		private int passwordMaxLength = 20;
		/**
		 * 密码最小长度
		 */
		private int passwordMinLength = 8;
	}
}
