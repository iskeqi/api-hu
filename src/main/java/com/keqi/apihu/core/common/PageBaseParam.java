package com.keqi.apihu.core.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 这个先留着，可能用不上，还是直接使用 QueryBaseParam 类比较好哦
 */
public class PageBaseParam {

    /**
     * 当前页数（最小为1）
     */
    @ApiModelProperty(value = "当前页数", example = "1", required = true)
    protected int pageNum = 1;

    /**
     * 每页大小（最大为50）
     */
    @ApiModelProperty(value = "每页大小", example = "10", required = true)
    protected int pageSize = 10;

    /**
     * 计算偏移量(使用方式：
     *
     * <if test="pageSize >= 0">
     * LIMIT #{offset}, #{pageSize})
     * </if>
     *
     * @return 偏移量
     */
    public int getOffset() {
        // pageSize <= 0 时，即查询所有记录
        return this.getPageSize() * (this.getPageNum() - 1);
    }

    public int getPageNum() {
        return pageNum <= 0 ? 1 : pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return Math.min(pageSize, 50);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
