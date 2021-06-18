package com.example.demo.vos.dept;

import com.example.demo.common.Page;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class DeptQueryVO extends Page {
    private String deptName;

    @Override
    public String toString() {
        return "DeptQueryVO{" +
                "deptName='" + deptName + '\'' +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? "%%" : "%" + deptName + "%";
    }
}
