package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class NoticeListDTO extends ResponsePage {
    private List<NoticeDTO> list;

    @Override
    public String toString() {
        return "NoticeListDTO{" +
                "list=" + list +
                '}';
    }

    public List<NoticeDTO> getList() {
        return list;
    }

    public void setList(List<NoticeDTO> list) {
        this.list = list;
    }
}
