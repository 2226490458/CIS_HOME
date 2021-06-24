package com.example.demo.vos;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 */

public class FaceVO {
    private Integer userId;
    private MultipartFile file;

    @Override
    public String toString() {
        return "FaceVO{" +
                "userId=" + userId +
                ", file=" + file +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
