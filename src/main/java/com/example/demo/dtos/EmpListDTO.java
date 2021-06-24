package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class EmpListDTO extends ResponsePage {
    List<EmpDTO> list;

    @Override
    public String toString() {
        return "EmpListDTO{" +
                "list=" + list +
                '}';
    }

    public List<EmpDTO> getList() {
        return list;
    }

    public void setList(List<EmpDTO> list) {
        this.list = list;
    }
}
