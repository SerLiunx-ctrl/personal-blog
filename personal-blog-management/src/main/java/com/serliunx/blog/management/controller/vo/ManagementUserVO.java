package com.serliunx.blog.management.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户信息响应
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/16
 */
@Data
public class ManagementUserVO {

	/**
	 * 用户id
	 */
	@Schema(description = "用户唯一ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long id;

	/**
	 * 用户名
	 */
	@Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED)
	private String username;

	/**
	 * 手机号
	 */
	@Schema(description = "用户手机号", requiredMode = Schema.RequiredMode.REQUIRED)
	private String phoneNumber;

	/**
	 * 邮箱
	 */
	@Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
	private String email;
}
