package com.example.demo.vos.user;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class UserAddVO {
    private String username;
    private String status;
    private String loginName;
    private Integer UserId;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "UserAddVO{" +
                "username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", loginName='" + loginName + '\'' +
                ", UserId=" + UserId +
                '}';
    }
}
