package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;
import com.example.demo.entity.Dept;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class DeptListDTO extends ResponsePage {
    private List<Dept> list;

    @Override
    public String toString() {
        return "DeptListDTO{" +
                "list=" + list +
                '}';
    }

    public List<Dept> getList() {
        return list;
    }

    public void setList(List<Dept> list) {
        this.list = list;
    }
}
