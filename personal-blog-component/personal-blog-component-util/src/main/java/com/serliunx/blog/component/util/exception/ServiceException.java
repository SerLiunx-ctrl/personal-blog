package com.serliunx.blog.component.util.exception;

import lombok.Getter;

/**
 * 业务异常
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/5
 */
@Getter
public class ServiceException extends RuntimeException {

	private final int code;

	public ServiceException(String message, int code) {
		super(message);
		this.code = code;
	}

	public ServiceException(String message) {
		this(message, 500);
	}
}
