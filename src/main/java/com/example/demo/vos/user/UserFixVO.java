package com.example.demo.vos.user;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class UserFixVO extends UserAddVO {
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserFixVO{" +
                "userId=" + userId +
                '}';
    }
}
