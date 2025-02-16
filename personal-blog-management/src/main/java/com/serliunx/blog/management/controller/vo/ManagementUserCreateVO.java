package com.serliunx.blog.management.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 后台用户创建参数
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/5
 */
@Data
public class ManagementUserCreateVO {
	/**
	 * 用户名
	 */
	@NotNull(message = "用户名不能为空!")
	@Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED)
	private String username;
	/**
	 * 密码
	 */
	@NotNull(message = "密码不能为空!")
	@Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
	private String password;
	/**
	 * 昵称
	 */
	@Schema(description = "昵称", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String nickname;
	/**
	 * 手机号
	 */
	@Schema(description = "手机号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String phoneNumber;
	/**
	 * 邮箱
	 */
	@Schema(description = "邮箱", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String email;
}
