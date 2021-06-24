package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;
import com.example.demo.entity.Dept;
import com.example.demo.entity.Document;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class DocListDTO extends ResponsePage {
    private List<Document> list;

    @Override
    public String toString() {
        return "DocListDTO{" +
                "list=" + list +
                '}';
    }

    public List<Document> getList() {
        return list;
    }

    public void setList(List<Document> list) {
        this.list = list;
    }
}
