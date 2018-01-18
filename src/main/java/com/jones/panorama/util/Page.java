package com.jones.panorama.util;

import com.jones.panorama.model.Query;

import java.util.List;

/**
 * Created by jones on 18-1-16.
 */
public class Page<T> {
    // 当前页
    private Integer currentPage = 1;
    private Integer number;
    // 每页显示的总条数
    private Integer pageSize = 20;
    // 总条数
    private Integer totalElements;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPages;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> content;

    public Page() {
        super();
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalNum, List<T> content) {
        super();
        currentPage = currentPage < 1 ? 1 : currentPage;
        this.currentPage = currentPage;
        this.number = currentPage - 1;
        this.pageSize = pageSize;
        this.totalElements = totalNum;
        this.totalPages = (this.totalElements+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPages?0:1;
        this.content = content;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Page(Query query, Integer totalNum, List<T> content){
        this(query.getCurrentPage(), query.getPageSize(), totalNum, content);
    }

    public Page(Query query, Integer totalNum){
        this(query.getCurrentPage(), query.getPageSize(), totalNum, null);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {

        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
