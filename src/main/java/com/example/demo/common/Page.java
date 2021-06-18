package com.example.demo.common;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class Page {
    private Integer page = 1;

    private Integer size = 10;

    public Integer getPage() {
        return (this.page - 1) * this.size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return (this.page - 1) * this.size;
    }
}
