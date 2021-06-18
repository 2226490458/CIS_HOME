package com.example.demo.vos.dept;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class DeptFixVO extends DeptAddVO {
    private Integer deptId;

    @Override
    public String toString() {
        return "DeptFixVO{" +
                "deptId=" + deptId +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
