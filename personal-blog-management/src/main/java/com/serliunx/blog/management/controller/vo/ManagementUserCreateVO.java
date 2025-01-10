package com.serliunx.blog.management.controller.vo;

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
	private String username;
	/**
	 * 密码
	 */
	@NotNull(message = "密码不能为空!")
	private String password;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 邮箱
	 */
	private String email;
}
