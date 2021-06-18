package com.example.demo.vos.doc;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class DocQueryVO {
    private String documentTitle;

    @Override
    public String toString() {
        return "UploadQueryVO{" +
                "documentTitle='" + documentTitle + '\'' +
                '}';
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }
}
