package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {
    private Integer documentId;

    private Integer userId;

    private String documentTitle;

    private String documentName;

    private String documentRemark;

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

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName == null ? null : documentName.trim();
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public void setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark == null ? null : documentRemark.trim();
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