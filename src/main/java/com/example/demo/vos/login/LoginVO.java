package com.example.demo.vos.login;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class LoginVO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
