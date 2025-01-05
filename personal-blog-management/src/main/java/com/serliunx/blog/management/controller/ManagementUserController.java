package com.serliunx.blog.management.controller;

import com.serliunx.blog.component.util.web.CommonResponse;
import com.serliunx.blog.management.entity.ManagementUser;
import com.serliunx.blog.management.service.ManagementUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理后台用户相关接口
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@RestController
@RequestMapping("management-user")
public class ManagementUserController {

	@Resource
	private ManagementUserService managementUserService;

	@GetMapping("by-id")
	public CommonResponse<ManagementUser> getUser(@RequestParam("id") Long id) {
		return CommonResponse.success(managementUserService.selectById(id));
	}
}
