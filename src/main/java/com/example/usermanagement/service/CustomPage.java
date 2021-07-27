package com.example.usermanagement.service;

import org.springframework.data.domain.Page;
import java.util.List;

public class CustomPage <T> {
    int page;
    int pageSize;
    long totalPage;
    List<T> users;

    public CustomPage(Page<T> page){
        this.page = page.getPageable().getPageNumber() + 1;
        this.pageSize = page.getPageable().getPageSize();
        this.totalPage = page.getTotalElements();
        this.users = page.getContent();
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
