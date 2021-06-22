package com.example.demo.vos.login;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */

public class LoginFaceVO {
    private MultipartFile faceImage;

    @Override
    public String toString() {
        return "LoginFaceVO{" +
                "faceImage=" + faceImage +
                '}';
    }

    public MultipartFile getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(MultipartFile faceImage) {
        this.faceImage = faceImage;
    }
}
