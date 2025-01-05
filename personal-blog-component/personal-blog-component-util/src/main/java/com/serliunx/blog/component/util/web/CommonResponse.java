package com.serliunx.blog.component.util.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * http统一响应结构
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@Data
@SuppressWarnings("all")
@RequiredArgsConstructor
public class CommonResponse<T> {

	/**
	 * 消息
	 */
	private final String msg;
	/**
	 * 响应码
	 */
	private final int code;
	/**
	 * 响应数据
	 */
	private final T data;

	/**
	 * 默认的响应成功消息
	 */
	public static final String MSG_SUCCESS = "操作成功!";
	/**
	 * 默认的响应失败消息(非异常)
	 */
	public static final String MSG_FAIL = "操作失败!";
	/**
	 * 默认的成功响应码
	 */
	public static final int CODE_SUCCESS = 200;
	/**
	 * 默认的失败响应码
	 */
	public static final int CODE_FAIL = 500;

	/**
	 * 操作成功
	 */
	public static <T> CommonResponse<T> success(String msg, T data) {
		return new CommonResponse<T>(msg, CODE_SUCCESS, data);
	}

	/**
	 * 操作成功
	 *
	 * @param data 数据
	 */
	public static <T> CommonResponse<T> success(T data) {
		return new CommonResponse<T>(MSG_SUCCESS, CODE_SUCCESS, data);
	}

	/**
	 * 操作成功
	 */
	public static <T> CommonResponse<T> success() {
		return new CommonResponse<T>(MSG_SUCCESS, CODE_SUCCESS, null);
	}

	/**
	 * 操作失败
	 */
	public static <T> CommonResponse<T> fail(String msg) {
		return new CommonResponse<T>(msg, CODE_FAIL, null);
	}

	/**
	 * 操作失败
	 */
	public static <T> CommonResponse<T> fail() {
		return new CommonResponse<T>(MSG_FAIL, CODE_FAIL, null);
	}
}
