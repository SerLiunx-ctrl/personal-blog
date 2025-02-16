package com.serliunx.blog.management.controller;

import com.serliunx.blog.component.util.reflection.BeanUtils;
import com.serliunx.blog.component.util.web.CommonResponse;
import com.serliunx.blog.management.config.ManagementConfiguration;
import com.serliunx.blog.management.controller.vo.UserConfigVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "配置管理", description = "管理系统配置接口")
public class ManagementConfigController {

	@Resource
	private ManagementConfiguration managementConfiguration;

	@GetMapping("user")
	@Operation(summary = "获取用户相关配置信息", description = "返回当前系统中用户相关的配置信息")
	public CommonResponse<UserConfigVO> userConfig() {
		return CommonResponse.success(BeanUtils.toBean(managementConfiguration.getUser(), UserConfigVO.class));
	}
}
