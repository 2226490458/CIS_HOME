package com.example.demo.vos.notice;

import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class NoticeDeleteVO {
    private List<Integer> ids;

    @Override
    public String toString() {
        return "JobDeleteVO{" +
                "ids=" + ids +
                '}';
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
