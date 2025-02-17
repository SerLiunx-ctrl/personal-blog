package com.serliunx.blog.management.service;

import com.serliunx.blog.component.util.web.PageResult;
import com.serliunx.blog.management.controller.vo.ManagementUserCreateVO;
import com.serliunx.blog.management.controller.vo.ManagementUserVO;
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
	 * 校验手机号是否已被使用
	 *
	 * @param phoneNumber	手机号
	 * @return	已被使用返回真, 否则返回假.
	 */
	boolean isPhoneNumberInUse(String phoneNumber);

	/**
	 * 校验邮箱是否已被使用
	 *
	 * @param email	邮箱
	 * @return 已被使用返回真, 否则返回假.
	 */
	boolean isEmailInUse(String email);

	/**
	 * 创建后台用户
	 * <li> 用户名、手机号、邮箱唯一
	 *
	 * @param createVO 参数
	 * @return 创建后的用户ID
	 */
	long create(ManagementUserCreateVO createVO);

	/**
	 * 删除指定后台用户
	 *
	 * @param id			用户ID
	 * @param checkExists	是否检查用户存在, 启用时如果不存在指定用户即会报错
	 */
	void delete(Long id, boolean checkExists);
}
