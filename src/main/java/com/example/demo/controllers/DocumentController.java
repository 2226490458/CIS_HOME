package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.entity.Document;
import com.example.demo.service.UploadService;
import com.example.demo.vos.doc.DocDeleteVO;
import com.example.demo.vos.doc.DocQueryVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 下载中心管理模块
 */
@RestController
public class DocumentController {
    @Resource
    private UploadService uploadService;


    @Value("${custom.doc.root}")
    private String root;

    @Value("${custom.doc.download}")
    private String downloadUrl;

    private void init(){
        File file = new File(root);
        if (!file.exists()){
            file.mkdir();
        }
    }


    @PostMapping("/updateDocs")
    public CommonResult<Object> updateDocs(MultipartFile file, Document document) throws IOException{
        init();
        if (file!=null){
            document.setDocumentName(file.getOriginalFilename());
            file.transferTo(new File(root, document.getDocumentName()));
        }
        return uploadService.updateDocs(document);
    }

    @PostMapping("/updateDocsText")
    public CommonResult<Object> updateDocs(@RequestBody Document document) throws IOException{
        init();
        return uploadService.updateDocs(document);
    }

    @PostMapping("/addDocs")
    public CommonResult<Object> addDocs(MultipartFile file, Document document) throws IOException {
        init();
        document.setDocumentName(file.getOriginalFilename());
        file.transferTo(new File(root, document.getDocumentName()));
        return uploadService.addDocs(document);
    }

    @PostMapping("/deleteDocs")
    public CommonResult<Object> deleteDocs(@RequestBody DocDeleteVO deleteVO){
        init();
        return uploadService.deleteDocs(deleteVO);
    }

    @GetMapping("/getDocs")
    public CommonResult<Object> getDocs(DocQueryVO queryVO){
        init();
        return uploadService.getDocs(queryVO);
    }

    @PostMapping("/downLoad")
    public CommonResult<Object> downLoad(@RequestBody Document document){
        init();
        String url = downloadUrl + document.getDocumentName();
        return CommonResult.success(url);
    }
}
