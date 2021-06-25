package com.example.demo.vos.notice;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class NoticeFixVO extends NoticeAddVO {
    private Integer noticeId;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    @Override
    public String toString() {
        return "NoticeFixVO{" +
                "noticeId=" + noticeId +
                '}';
    }
}
