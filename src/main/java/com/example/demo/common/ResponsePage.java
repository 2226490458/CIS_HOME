package com.example.demo.common;

/**
 * @author 青菜白玉堂
 * @create 2021-06-21
 */
public class ResponsePage {
    private Integer total;

    @Override
    public String toString() {
        return "ResponsePage{" +
                "total=" + total +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
