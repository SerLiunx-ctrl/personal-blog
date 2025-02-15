package com.serliunx.blog.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.serliunx.blog.component.util.exception.ServiceException;
import com.serliunx.blog.component.util.reflection.BeanUtils;
import com.serliunx.blog.management.config.ManagementConfiguration;
import com.serliunx.blog.management.controller.vo.ManagementUserCreateVO;
import com.serliunx.blog.management.entity.ManagementUser;
import com.serliunx.blog.management.mapper.ManagementUserMapper;
import com.serliunx.blog.management.service.ManagementUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 管理后台用户服务实现
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@Service
public class ManagementUserServiceImpl implements ManagementUserService {

	@Resource
	private ManagementUserMapper managementUserMapper;
	@Resource
	private ManagementConfiguration managementConfiguration;

	@Override
	public ManagementUser selectById(Long id) {
		return managementUserMapper.selectById(id);
	}

	@Override
	public ManagementUser selectByUsername(String username) {
		if (username == null ||
				username.isEmpty()) {
			return null;
		}
		return managementUserMapper.selectOne(new LambdaQueryWrapper<ManagementUser>()
				.eq(ManagementUser::getUsername, username)
		);
	}

	@Override
	public boolean isManagementUserExists(String username) {
		return managementUserMapper.selectCount(new LambdaQueryWrapper<ManagementUser>()
				.eq(ManagementUser::getUsername, username)
		) > 0;
	}

	@Override
	public boolean isPhoneNumberInUse(String phoneNumber) {
		return managementUserMapper.selectCount(new LambdaQueryWrapper<ManagementUser>()
				.eq(ManagementUser::getPhoneNumber, phoneNumber)
		) > 0;
	}

	@Override
	public boolean isEmailInUse(String email) {
		return managementUserMapper.selectCount(new LambdaQueryWrapper<ManagementUser>()
				.eq(ManagementUser::getEmail, email)
		) > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public long create(ManagementUserCreateVO createVO) {
		if (isManagementUserExists(createVO.getUsername())) {
			throw new ServiceException("该用户名已被使用！");
		}

		if (isEmailInUse(createVO.getEmail())) {
			throw new ServiceException("该邮箱已被使用！");
		}

		if (isPhoneNumberInUse(createVO.getPhoneNumber())) {
			throw new ServiceException("该手机号已被使用！");
		}

		// 校验用户名、密码合法性
		validateBasicInfo(createVO.getUsername(), createVO.getPassword());

		ManagementUser managementUser = BeanUtils.toBean(createVO, ManagementUser.class);
		managementUserMapper.insert(managementUser);

		return managementUser.getId();
	}

	/**
	 * 基本信息校验
	 */
	private void validateBasicInfo(String username, String password) {
		final ManagementConfiguration.User userConfig = managementConfiguration.getUser();
		final int passwordMaxLength = userConfig.getPasswordMaxLength();
		final int passwordMinLength = userConfig.getPasswordMinLength();
		final int usernameMaxLength = userConfig.getUsernameMaxLength();
		final int usernameMinLength = userConfig.getUsernameMinLength();

		if (username.length() > usernameMaxLength ||
				username.length() < usernameMinLength) {
			throw new ServiceException(String.format("用户名长度必须在 %s 和 %s 之间!",
					usernameMinLength, usernameMaxLength));
		}

		if (password.length() > passwordMaxLength ||
				password.length() < passwordMinLength) {
			throw new ServiceException(String.format("密码长度必须在 %s 和 %s 之间!",
					passwordMinLength, passwordMaxLength));
		}
	}
}
