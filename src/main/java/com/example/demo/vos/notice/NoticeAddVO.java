package com.example.demo.vos.notice;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class NoticeAddVO {
    private Integer userId;

    private String noticeTitle;

    private String noticeContent;

    @Override
    public String toString() {
        return "NoticeAddVO{" +
                "userId=" + userId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
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
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
}
