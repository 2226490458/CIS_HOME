package com.example.demo.vos.user;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class UserAddVO {
    private String userName;
    private String loginName;
    private Integer empId;
    private Integer status;
    private String userPwd;

    @Override
    public String toString() {
        return "UserAddVO{" +
                "userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", empId=" + empId +
                ", status=" + status +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
