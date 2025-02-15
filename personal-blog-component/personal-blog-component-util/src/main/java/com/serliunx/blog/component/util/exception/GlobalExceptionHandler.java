package com.serliunx.blog.component.util.exception;

import com.serliunx.blog.component.util.config.CommonConfiguration;
import com.serliunx.blog.component.util.web.CommonResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

	@Resource
	private CommonConfiguration commonConfiguration;

	/**
	 * 处理未知异常信息
	 * <li> 请根据日志的输出内容定位异常
	 */
	@ExceptionHandler(Exception.class)
	public CommonResponse<Void> handleUnknownException(Exception e) {
		log.error("发生未知异常: ", e);
		return CommonResponse.fail("系统发生未知错误, 请与管理人员取得联系!");
	}

	/**
	 * 静态资源访问失败异常
	 */
	@ExceptionHandler(NoResourceFoundException.class)
	public CommonResponse<Void> handleNoResourceFoundException(NoResourceFoundException e) {
		return CommonResponse.fail("无法访问该资源!");
	}

	/**
	 * 请求参数异常
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public CommonResponse<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		loggingWarn("接口参数缺失!");
		return CommonResponse.fail("请求参数异常!");
	}

	/**
	 * 请求参数缺失
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public CommonResponse<Void> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		return CommonResponse.fail("请求参数缺失: " + e.getParameterName());
	}

	/**
	 * 自定义业务异常
	 */
	@ExceptionHandler(ServiceException.class)
	public CommonResponse<Void> handleServiceException(ServiceException e) {
		if (commonConfiguration.isOutputServiceException()) {
			loggingWarn(e.getMessage());
		}
		return CommonResponse.fail(e.getMessage(), e.getCode());
	}

	/**
	 * 参数校验失败异常
	 */
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
