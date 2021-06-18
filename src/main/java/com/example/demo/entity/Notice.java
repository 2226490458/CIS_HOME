package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer noticeId;

    private Integer userId;

    private String noticeTitle;

    private String noticeContent;

    private Date noticeCreate;

    private static final long serialVersionUID = 1L;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeCreate() {
        return noticeCreate;
    }

    public void setNoticeCreate(Date noticeCreate) {
        this.noticeCreate = noticeCreate;
    }
}