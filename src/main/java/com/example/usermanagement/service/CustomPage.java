package com.example.usermanagement.service;

import org.springframework.data.domain.Page;
import java.util.List;

public class CustomPage <T> {
    private int page;
    private int pageSize;
    private long totalPage;
    private List<T> users;

    public CustomPage(Page<T> page){
        this.page = page.getPageable().getPageNumber() + 1;
        this.pageSize = page.getPageable().getPageSize();
        this.totalPage = getPageNumber(page);
        this.users = page.getContent();

    }

    private long getPageNumber(Page<T> page) {
        long initPageNumber = page.getTotalElements()/page.getPageable().getPageSize();
        return page.getTotalElements()%page.getPageable().getPageSize()==0 ? initPageNumber : initPageNumber + 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }
}
