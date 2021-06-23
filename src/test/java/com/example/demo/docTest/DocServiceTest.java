package com.example.demo.docTest;

import com.example.demo.common.CommonResult;
import com.example.demo.entity.Document;
import com.example.demo.mapper.DocumentMapper;
import com.example.demo.service.UploadService;
import com.example.demo.vos.doc.DocDeleteVO;
import com.example.demo.vos.doc.DocQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DocServiceTest {

    @Resource
    private UploadService uploadService;

    @Test
    public void updateDocsTest(){
        Document document = new Document();
        document.setDocumentId(1);
        document.setDocumentRemark("内容是学习用桶来泡泡面");
        CommonResult<Object> objectCommonResult = uploadService.updateDocs(document);
        System.out.println(objectCommonResult.getMessage());
    }

    @Test
    public void getDocsTest(){
        DocQueryVO queryVO = new DocQueryVO();
        queryVO.setDocumentTitle("泡面桶说明书");
        queryVO.setPage(1);
        queryVO.setSize(10);
        CommonResult<Object> objectCommonResult = uploadService.getDocs(queryVO);
        System.out.println(objectCommonResult.getData());
    }

    @Test
    public void deleteDocsTest(){
        List<Integer> ids= new ArrayList<>();
        ids.add(5);
        DocDeleteVO deleteVO = new DocDeleteVO();
        deleteVO.setIds(ids);
        CommonResult<Object> objectCommonResult = uploadService.deleteDocs(deleteVO);
        System.out.println(objectCommonResult.getMessage());
    }

    @Test
    public void addDocsTest(){
        Document document = new Document();
        document.setDocumentName("lala");
        document.setDocumentTitle("测试");
        document.setDocumentStatus(1);
        document.setDocumentRemark("测试是正确的吗");
        CommonResult<Object> objectCommonResult = uploadService.addDocs(document);
        System.out.println(objectCommonResult.getMessage());
    }

}
