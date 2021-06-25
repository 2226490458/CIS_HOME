package com.example.demo.vos.user;

import com.example.demo.common.Page;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class UserQueryVO extends Page {
    private String userName;
    private Integer status;

    @Override
    public String toString() {
        return "UserQueryVO{" +
                "userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || "".equals(userName)) {
            this.userName = null;
        } else {
            this.userName = "%" + userName + "%";
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
