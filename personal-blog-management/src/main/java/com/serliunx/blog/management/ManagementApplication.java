package com.serliunx.blog.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 管理后台启动器
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/1
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.serliunx.blog")
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class);
	}
}
