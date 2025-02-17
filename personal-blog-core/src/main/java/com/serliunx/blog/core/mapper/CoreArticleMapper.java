package com.serliunx.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serliunx.blog.core.entity.CoreArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * 核心系统文章表映射
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/17
 */
@Mapper
public interface CoreArticleMapper extends BaseMapper<CoreArticle> {}
