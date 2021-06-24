package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;
import com.example.demo.entity.Cusers;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class UserListDTO extends ResponsePage {
    private List<Cusers> list;

    @Override
    public String toString() {
        return "UserListDTO{" +
                "list=" + list +
                '}';
    }

    public List<Cusers> getList() {
        return list;
    }

    public void setList(List<Cusers> list) {
        this.list = list;
    }
}
