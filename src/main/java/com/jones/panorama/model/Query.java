package com.jones.panorama.model;

public class Query<T> {
    private static final int DEFAULT_PAGE_SIZE = 20;
    private Integer startRow;
    private int currentPage = 1;
    private int pageSize = 20;
    private T query;

    public Query() {
    }

    public Query(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        this.currentPage = pageNum;
        this.pageSize = pageSize;
        this.startRow = Integer.valueOf((pageNum - 1) * pageSize);
    }

    public Query(T query) {
        this.query = query;
    }

    public Query(int pageNum) {
        this(pageNum, 20);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStartRow() {
        return this.startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getQuery() {
        return this.query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
}
