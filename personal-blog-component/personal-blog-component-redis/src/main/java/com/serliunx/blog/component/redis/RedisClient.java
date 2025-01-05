package com.serliunx.blog.component.redis;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 封装的Redis客户端
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/3
 */
@Component
public final class RedisClient {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 设置缓存值
	 *
	 * @param key		键
	 * @param value		值
	 * @param timeUnit	时间单位
	 * @param timeout	时间
	 */
	public void set(String key, Object value, TimeUnit timeUnit, long timeout) {
		redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
	}

	/**
	 * 设置缓存值
	 * <li> 以秒为时间单位
	 *
	 * @param key		键
	 * @param value		值
	 * @param timeout	时间
	 */
	public void set(String key, Object value, long timeout) {
		set(key, value, TimeUnit.SECONDS, timeout);
	}

	/**
	 * 设置缓存值
	 * <li> 长期存活
	 *
	 * @param key	键
	 * @param value	值
	 */
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 获取指定缓存
	 *
	 * @param key	键
	 * @return 值
	 * @param <T>	类型, 这里取决于接受返回值的参数类型
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) redisTemplate.opsForValue().get(key);
	}

	/**
	 * 移除指定缓存
	 *
	 * @param key	键
	 */
	public void remove(String key) {
		redisTemplate.delete(key);
	}
}
