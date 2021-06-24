package com.example.demo.dtos.sys;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 * 部门配置类
 */
public class DeptSettingDTO {
    private String deptName;
    private Integer code;

    @Override
    public String toString() {
        return "DeptSettingDTO{" +
                "deptName='" + deptName + '\'' +
                ", code=" + code +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
