package com.serliunx.blog.management.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户相关配置响应数据
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/16
 */
@Data
public class UserConfigVO {
	/**
	 * 用户名最大长度
	 */
	@Schema(description = "用户名最大长度", requiredMode = Schema.RequiredMode.REQUIRED)
	private int usernameMaxLength = 20;
	/**
	 * 用户名最小长度
	 */
	@Schema(description = "用户名最小长度", requiredMode = Schema.RequiredMode.REQUIRED)
	private int usernameMinLength = 4;
	/**
	 * 密码最大长度
	 */
	@Schema(description = "密码最大长度", requiredMode = Schema.RequiredMode.REQUIRED)
	private int passwordMaxLength = 20;
	/**
	 * 密码最小长度
	 */
	@Schema(description = "密码最小长度", requiredMode = Schema.RequiredMode.REQUIRED)
	private int passwordMinLength = 8;
}
