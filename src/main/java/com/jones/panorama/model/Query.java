package com.jones.panorama.model;

/**
 * Created by jones on 18-1-17.
 */
public class Query<T> {
    private static final int DEFAULT_PAGE_SIZE = 20;
    private int startRow = 0;
    private int currentPage = 1;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private T query;

    public Query() {
    }

    public Query(int pageNum, int pageSize){
        pageNum = pageNum < 1 ? 1 : pageNum;
        this.currentPage = pageNum;
        this.pageSize = pageSize;
        this.startRow = (pageNum - 1) * pageSize;
    }

    public Query(int pageNum){
        this(pageNum, DEFAULT_PAGE_SIZE);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
}
