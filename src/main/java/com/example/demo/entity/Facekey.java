package com.example.demo.entity;

import java.io.Serializable;

public class Facekey implements Serializable {
    private Integer faceid;

    private String appid;

    private String apikey;

    private String secretkey;

    private Integer threshold;

    private static final long serialVersionUID = 1L;

    public Integer getFaceid() {
        return faceid;
    }

    public void setFaceid(Integer faceid) {
        this.faceid = faceid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey == null ? null : apikey.trim();
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey == null ? null : secretkey.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}