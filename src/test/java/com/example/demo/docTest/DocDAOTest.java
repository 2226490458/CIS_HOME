package com.example.demo.docTest;

import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.entity.Document;
import com.example.demo.mapper.DocumentMapper;
import com.example.demo.vos.doc.DocQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
@SpringBootTest
public class DocDAOTest {
    @Resource
    private DocumentMapper documentMapper;


    @Test
    public void saveDocTest() {
        Document document = new Document();
        document.setUserId(3);
        document.setDocumentName("泡面桶说明书");
        document.setDocumentRemark("本书就如何用桶来泡泡面进行详细说明");
        document.setDocumentTitle("泡面桶说明书");
        document.setDocumentStatus(RecordExistEnum.exist.getCode());
        int code = documentMapper.insert(document);
        System.out.println(code);
    }

    @Test
    public void listOfDocTest() {
        DocQueryVO queryVO = new DocQueryVO();
        queryVO.setDocumentTitle("泡面");
        queryVO.setPage(1);
        queryVO.setSize(10);
        List<Document> documentList = documentMapper.listOfDocument(queryVO);
        System.out.println(documentList.size());
    }

    @Test
    public void updateDocTest() {
        Document document = new Document();
        document.setDocumentId(1);
        document.setDocumentRemark("内容修改一下， 本书就如何用桶来泡泡面进行详细说明");
        int code = documentMapper.updateByPrimaryKeySelective(document);
        System.out.println(code);
    }
}
