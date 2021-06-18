package com.example.demo.vos.dept;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class DeptAddVO {
    private String deptName;
    private String deptRemark;

    @Override
    public String toString() {
        return "DeptAddVO{" +
                "deptName='" + deptName + '\'' +
                ", deptRemark='" + deptRemark + '\'' +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark;
    }
}
