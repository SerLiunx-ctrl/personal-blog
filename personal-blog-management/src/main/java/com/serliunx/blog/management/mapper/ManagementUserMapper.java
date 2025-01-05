package com.serliunx.blog.management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serliunx.blog.management.entity.ManagementUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理后台用户表映射
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/1/2
 */
@Mapper
public interface ManagementUserMapper extends BaseMapper<ManagementUser> {}
