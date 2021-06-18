package com.example.demo.vos.emp;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class EmpQueryVO {
    private Integer employeeId;
    private Integer sex;
    private String employeeName;
    private String phone;
    private String cardId;
    private Integer deptId;

    @Override
    public String toString() {
        return "EmpQueryVO{" +
                "employeeId=" + employeeId +
                ", sex=" + sex +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", cardId='" + cardId + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
