package com.example.demo.dtos;

import com.example.demo.common.ResponsePage;
import com.example.demo.entity.Job;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-24
 */
public class JobListDTO  extends ResponsePage {
    private List<Job> list;

    @Override
    public String toString() {
        return "JobListDTO{" +
                "list=" + list +
                '}';
    }

    public List<Job> getList() {
        return list;
    }

    public void setList(List<Job> list) {
        this.list = list;
    }
}
