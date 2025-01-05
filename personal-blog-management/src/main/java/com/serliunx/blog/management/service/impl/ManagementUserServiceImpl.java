package com.serliunx.blog.management.service.impl;

import com.serliunx.blog.management.entity.ManagementUser;
import com.serliunx.blog.management.mapper.ManagementUserMapper;
import com.serliunx.blog.management.service.ManagementUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
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

	@Override
	public ManagementUser selectById(Long id) {
		return managementUserMapper.selectById(id);
	}
}
