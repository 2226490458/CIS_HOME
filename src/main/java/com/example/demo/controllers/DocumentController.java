package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.entity.Document;
import com.example.demo.service.UploadService;
import com.example.demo.vos.doc.DocDeleteVO;
import com.example.demo.vos.doc.DocQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    /**
     * 更新文档
     * @param file 文档文件
     * @param document 文档信息
     * @return
     * @throws IOException
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/updateDocs")
    public CommonResult<Object> updateDocs(MultipartFile file, Document document) throws IOException{
        if (file!=null){
            document.setDocumentName(file.getOriginalFilename());
            file.transferTo(new File(root, document.getDocumentName()));
        }
        return uploadService.updateDocs(document);
    }

    /**
     * 更新文档信息
     * @param document
     * @return
     * @throws IOException
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/updateDocsText")
    public CommonResult<Object> updateDocs(@RequestBody Document document) throws IOException{
        return uploadService.updateDocs(document);
    }

    /**
     * 添加文档
     * @param file
     * @param document
     * @return
     * @throws IOException
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/addDocs")
    public CommonResult<Object> addDocs(MultipartFile file, Document document) throws IOException {
        init();
        document.setDocumentName(file.getOriginalFilename());
        file.transferTo(new File(root, document.getDocumentName()));
        return uploadService.addDocs(document);
    }

    /**
     * 删除文档
     * @param deleteVO
     * @return
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/deleteDocs")
    public CommonResult<Object> deleteDocs(@RequestBody DocDeleteVO deleteVO){
        return uploadService.deleteDocs(deleteVO);
    }

    /**
     * 分页查询文档
     * @param queryVO
     * @return
     */
    @GetMapping("/getDocs")
    public CommonResult<Object> getDocs(DocQueryVO queryVO){
        return uploadService.getDocs(queryVO);
    }

    /**
     * 下载
     * @param document
     * @return
     */
    @PostMapping("/downLoad")
    public CommonResult<Object> downLoad(@RequestBody Document document){
        String url = downloadUrl + document.getDocumentName();
        return CommonResult.success(url);
    }
}
