package com.serliunx.blog.management.service;

import com.serliunx.blog.management.entity.ManagementUser;

/**
 * 管理后台用户服务
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
public interface ManagementUserService {

	/**
	 * 根据ID查询管理后台用户信息
	 *
	 * @param id ID
	 * @return 管理后台用户信息
	 */
	ManagementUser selectById(Long id);
}
