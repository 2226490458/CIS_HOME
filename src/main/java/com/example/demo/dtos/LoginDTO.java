package com.example.demo.dtos;

import com.example.demo.entity.Cusers;

/**
 * @author 青菜白玉堂
 * @create 2021-06-23
 */
public class LoginDTO {
    private Cusers user;
    private String token;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }

    public Cusers getUser() {
        return user;
    }

    public void setUser(Cusers user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
