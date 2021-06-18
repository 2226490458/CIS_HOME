package com.example.demo.vos.emp;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class EmpDeleteVO {
    private List<Integer> ids;

    @Override
    public String toString() {
        return "EmpDeleteVO{" +
                "ids=" + ids +
                '}';
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
