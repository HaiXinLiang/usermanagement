package com.example.usermanagement.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.util.List;

@Configurable
public class CustomPage <T> {
    List<T> content;
    CustomPageable pageable;

//    @Bean
//    public CustomPage<T> CustomPage(Page<T> page){
//        return new CustomPage<T>(page);
//    }


    public CustomPage(Page<T> page){
        this.content = page.getContent();
        this.pageable = new CustomPageable(page.getPageable().getPageNumber(), page.getPageable().getPageSize(),page.getTotalElements());
    }

    private class CustomPageable {
            int pageNumber;
            int pageSize;
            long totalElements;

        public CustomPageable(int pageNumber, int pageSize, long totalElements) {
                this.pageNumber = pageNumber;
                this.pageSize = pageSize;
                this.totalElements = totalElements;
        }
    }


    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public CustomPageable getPageable() {
        return pageable;
    }

    public void setPageable(CustomPageable pageable) {
        this.pageable = pageable;
    }
}
