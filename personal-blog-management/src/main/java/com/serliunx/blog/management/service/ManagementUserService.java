package com.serliunx.blog.management.service;

import com.serliunx.blog.management.controller.vo.ManagementUserCreateVO;
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

	/**
	 * 根据用户名查询管理后台用户信息
	 *
	 * @param username	用户名
	 * @return 管理后台用户信息
	 */
	ManagementUser selectByUsername(String username);

	/**
	 * 校验管理后台用户信息是否存在
	 * <li> 使用用户名校验
	 *
	 * @param username	用户名
	 * @return	存在返回真, 否则返回假.
	 */
	boolean isManagementUserExists(String username);

	/**
	 * 创建后台用户
	 * <li> 用户名唯一
	 *
	 * @param createVO 参数
	 */
	void create(ManagementUserCreateVO createVO);
}
