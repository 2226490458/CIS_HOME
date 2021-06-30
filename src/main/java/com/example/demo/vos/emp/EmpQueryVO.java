package com.example.demo.vos.emp;

import com.example.demo.common.Page;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class EmpQueryVO extends Page {
    private Integer jobId;
    private Integer sex;
    private String employeeName;
    private String phone;
    private String cardId;
    private Integer deptId;

    @Override
    public String toString() {
        return "EmpQueryVO{" +
                "jobId=" + jobId +
                ", sex=" + sex +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", cardId='" + cardId + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex =  sex;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? "%%" : "%" + employeeName + "%";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = "".equals(phone) ? null : phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = "".equals(cardId) ? null : cardId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
