package com.serliunx.blog.management.controller;

import com.serliunx.blog.component.util.web.CommonResponse;
import com.serliunx.blog.management.config.ManagementConfiguration;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理后台相关配置接口
 * <p> 主要用于将配置信息传递给前端使用
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/5
 */
@RestController
@RequestMapping("config")
public class ManagementConfigController {

	@Resource
	private ManagementConfiguration managementConfiguration;

	@GetMapping("user")
	public CommonResponse<ManagementConfiguration.User> userConfig() {
		return CommonResponse.success(managementConfiguration.getUser());
	}
}
