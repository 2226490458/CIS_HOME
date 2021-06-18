package com.example.demo.dtos;

import com.example.demo.entity.Notice;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 */
public class NoticeDTO extends Notice {
    private String userName;

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
