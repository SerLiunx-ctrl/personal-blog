package com.serliunx.blog.component.util.reflection;

import org.springframework.util.Assert;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象属性复制相关工具类
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/11
 */
public final class BeanUtils {

	private BeanUtils() {throw new UnsupportedOperationException();}

	/**
	 * 转换对象(复制对象同名属性)
	 *
	 * @param src			源对象
	 * @param targetClass	目标对象类
	 * @return 目标对象
	 * @param <T> 目标对象类型, 取决于所指定的目标对象类(targetClass)
	 */
	public static <T> T toBean(Object src, Class<T> targetClass) {
		if (src == null) {
			return null;
		}
		Assert.notNull(targetClass, "targetClass must not be null");

		try {
			final Constructor<T> emptyC = targetClass.getDeclaredConstructor();
			emptyC.setAccessible(true);
			T result = emptyC.newInstance();
			org.apache.commons.beanutils.BeanUtils.copyProperties(result, src);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 转换对象集合(复制对象同名属性)
	 *
	 * @param src			源对象集合
	 * @param targetClass	目标对象类
	 * @return 目标对象集合
	 * @param <T> 目标对象类型, 取决于所指定的目标对象类(targetClass)
	 */
	public static <T> List<T> toBean(List<?> src, Class<T> targetClass) {
		Assert.notNull(src, "src must not be null");
		Assert.notNull(targetClass, "targetClass must not be null");
		List<T> result = new ArrayList<>(src.size());
		for (Object o : src) {
			result.add(toBean(o, targetClass));
		}
		return result;
	}
}
