package com.example.demo.vos.login;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */

public class LoginFaceVO {
    private String base64Image;

    @Override
    public String toString() {
        return "LoginFaceVO{" +
                "base64Image='" + base64Image + '\'' +
                '}';
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
