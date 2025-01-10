package com.serliunx.blog.component.util.exception;

import com.serliunx.blog.component.util.web.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用异常处理
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/5
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public CommonResponse<Void> handleUnknownException(Exception e) {
		log.error("发生未知异常: ", e);
		return CommonResponse.fail("系统发生未知错误, 请与管理人员取得联系!");
	}

	@ExceptionHandler(ServiceException.class)
	public CommonResponse<Void> handleServiceException(ServiceException e) {
		loggingWarn(e.getMessage());
		return CommonResponse.fail(e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResponse<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		final BindingResult bindingResult = e.getBindingResult();
		final String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
		loggingWarn("接口参数校验失败 => {}", message);
		return CommonResponse.fail(message);
	}

	/**
	 * 控制台输出异常文本信息
	 *
	 * @param prefix	前缀
	 * @param message	文本
	 */
	private static void loggingWarn(String prefix, String message) {
		log.warn(prefix, message);
	}

	/**
	 * 控制台输出异常文本信息
	 *
	 * @param message	文本
	 */
	private static void loggingWarn(String message) {
		loggingWarn("异常信息 => {}", message);
	}
}
