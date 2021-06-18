package com.example.demo.vos.doc;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class DocAddVO {
    private String documentTitle;

    private String docementName;

    private String docementRemark;

    @Override
    public String toString() {
        return "UploadAddVO{" +
                "documentTitle='" + documentTitle + '\'' +
                ", docementName='" + docementName + '\'' +
                ", docementRemark='" + docementRemark + '\'' +
                '}';
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocementName() {
        return docementName;
    }

    public void setDocementName(String docementName) {
        this.docementName = docementName;
    }

    public String getDocementRemark() {
        return docementRemark;
    }

    public void setDocementRemark(String docementRemark) {
        this.docementRemark = docementRemark;
    }
}
