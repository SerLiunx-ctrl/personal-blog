package com.serliunx.blog.component.util.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 分页查询结果封装
 *
 * @author <a href="mailto:serliunx@yeah.net">SerLiunx</a>
 * @version 1.0.0
 * @since 2025/2/17
 */
@Data
public final class PageResult<T> {
    /**
     * 当前页码
     */
    @Schema(description = "当前页码", requiredMode = Schema.RequiredMode.REQUIRED)
    private long current;
    /**
     * 总数据量
     */
    @Schema(description = "总数据量", requiredMode = Schema.RequiredMode.REQUIRED)
    private long total;
    /**
     * 数据
     */
    @Schema(description = "数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<T> rows;
}
