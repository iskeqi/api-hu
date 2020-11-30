package com.keqi.apihu.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 基础查询实体类（仅用于规范命名，不要求必须继承，可以拷贝需要的属性至自己的Param实体类中）
 */
public class QueryBaseParam {

    /**
     * 当前页数（最小为1）
     */
    @ApiModelProperty(value = "当前页数", example = "1", required = true)
    protected int page = 1;

    /**
     * 每页大小（最大为50）
     */
    @ApiModelProperty(value = "每页大小", example = "10", required = true)
    protected int size = 10;

    /**
     * 搜索字段名称
     */
    @ApiModelProperty(value = "搜索字段名称", example = "null")
    protected String searchName;

    /**
     * 搜索字段值
     */
    @ApiModelProperty(value = "搜索字段值", example = "null")
    protected String searchValue;

    /**
     * 开始日期
     */
    @ApiModelProperty(value = "开始日期", example = "1000-01-01")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate beginDate;

    /**
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期", example = "9999-12-12")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate endDate;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "1000-01-01 00:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime beginTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", example = "9999-12-12 23:59:59")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime endTime;

    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段", example = "null")
    protected String orderFiled;

    /**
     * 排序类型（升序：ASC，降序：DESC）
     */
    @ApiModelProperty(value = "排序类型", example = "asc/desc")
    protected OrderTypeEnum orderType;

    public QueryBaseParam() {
    }

    public String getOrderFiled() {
        return orderFiled;
    }

    public void setOrderFiled(String orderFiled) {
        this.orderFiled = orderFiled;
    }

    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 计算偏移量(使用方式：
     *
     * <if test="size >= 0">
     * LIMIT #{offset}, #{size})
     * </if>
     *
     * @return 偏移量
     */
    public int getOffset() {
        // pageSize <= 0 时，即查询所有记录
        return this.getSize() * (this.getPage() - 1);
    }

    public int getPage() {
        return page <= 0 ? 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return Math.min(size, 50);
    }

    public void setSize(int size) {
        this.size = size;
    }
}
