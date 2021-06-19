package com.example.demo.vos;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */

public class PasswordVO {
    private Integer userId;
    private String oldPsw;
    private String newPsw;

    @Override
    public String toString() {
        return "PasswordVO{" +
                "userId=" + userId +
                ", oldPsw='" + oldPsw + '\'' +
                ", newPsw='" + newPsw + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldPsw() {
        return oldPsw;
    }

    public void setOldPsw(String oldPsw) {
        this.oldPsw = oldPsw;
    }

    public String getNewPsw() {
        return newPsw;
    }

    public void setNewPsw(String newPsw) {
        this.newPsw = newPsw;
    }
}
