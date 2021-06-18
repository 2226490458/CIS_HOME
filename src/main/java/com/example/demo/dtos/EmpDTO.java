package com.example.demo.dtos;

import com.example.demo.entity.Employee;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 */
public class EmpDTO extends Employee {
    private String deptName;
    private String jobName;

    @Override
    public String toString() {
        return "EmpDTO{" +
                "deptName='" + deptName + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
