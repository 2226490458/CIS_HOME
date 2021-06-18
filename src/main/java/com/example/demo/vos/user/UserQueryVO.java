package com.example.demo.vos.user;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class UserQueryVO {
    private String username;
    private String status;

    @Override
    public String toString() {
        return "EmpQueryVO{" +
                "username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
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

}
