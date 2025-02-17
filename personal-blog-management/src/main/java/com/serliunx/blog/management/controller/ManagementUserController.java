package com.serliunx.blog.management.controller;

import com.serliunx.blog.component.util.reflection.BeanUtils;
import com.serliunx.blog.component.util.web.CommonResponse;
import com.serliunx.blog.management.controller.vo.ManagementUserCreateVO;
import com.serliunx.blog.management.controller.vo.ManagementUserVO;
import com.serliunx.blog.management.service.ManagementUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台用户相关接口
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@RestController
@RequestMapping("management-user")
@Tag(name = "用户管理", description = "用户相关接口")
public class ManagementUserController {

	@Resource
	private ManagementUserService managementUserService;

	@GetMapping("get-by-id")
	@Operation(summary = "根据ID获取用户信息", description = "返回指定ID的用户信息")
	public CommonResponse<ManagementUserVO> getUser(@RequestParam("id") Long id) {
		return CommonResponse.success(BeanUtils.toBean(managementUserService.selectById(id), ManagementUserVO.class));
	}

	@PostMapping("create")
	@Operation(summary = "创建用户", description = "根据传入的用户信息创建用户")
	public CommonResponse<Long> createManagementUser(@RequestBody @Validated ManagementUserCreateVO createVO) {
		return CommonResponse.success(managementUserService.create(createVO));
	}

	@PostMapping("delete")
	@Operation(summary = "删除用户", description = "删除指定ID的后台用户")
	public CommonResponse<Void> deleteManagementUser(@RequestParam("id") Long id) {
		managementUserService.delete(id, true);
		return CommonResponse.success();
	}
}
