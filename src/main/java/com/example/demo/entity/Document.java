package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {
    private Integer documentId;

    private Integer userId;

    private String documentTitle;

    private String docementName;

    private String docementRemark;

    private Date documentCreate;

    private Integer documentStatus;

    private static final long serialVersionUID = 1L;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle == null ? null : documentTitle.trim();
    }

    public String getDocementName() {
        return docementName;
    }

    public void setDocementName(String docementName) {
        this.docementName = docementName == null ? null : docementName.trim();
    }

    public String getDocementRemark() {
        return docementRemark;
    }

    public void setDocementRemark(String docementRemark) {
        this.docementRemark = docementRemark == null ? null : docementRemark.trim();
    }

    public Date getDocumentCreate() {
        return documentCreate;
    }

    public void setDocumentCreate(Date documentCreate) {
        this.documentCreate = documentCreate;
    }

    public Integer getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(Integer documentStatus) {
        this.documentStatus = documentStatus;
    }
}