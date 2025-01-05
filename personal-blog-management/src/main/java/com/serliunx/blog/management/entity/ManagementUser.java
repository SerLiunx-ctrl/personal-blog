package com.serliunx.blog.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 管理后台用户实体
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@Data
@TableName("management_user")
public class ManagementUser {

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;
}
