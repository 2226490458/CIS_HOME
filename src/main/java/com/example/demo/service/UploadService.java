package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.DocListDTO;
import com.example.demo.entity.Document;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.DocumentMapper;
import com.example.demo.vos.doc.DocDeleteVO;
import com.example.demo.vos.doc.DocQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class UploadService {
    @Resource
    private DocumentMapper documentMapper;

    /**
     * 查询文档业务
     * @param queryVO
     * @return
     */
    public CommonResult<Object> getDocs(DocQueryVO queryVO){
        List<Document> documentList = documentMapper.listOfDocument(queryVO);
        Integer amount = documentMapper.selectDocAmount(queryVO);
        DocListDTO listDTO = new DocListDTO();
        listDTO.setList(documentList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    /**
     * 删除文档的业务代码
     * @param deleteVO
     * @return
     */
    public CommonResult<Object> deleteDocs(DocDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id->{
            Document document = new Document();
            document.setDocumentId(id);
            document.setDocumentStatus(0);
            documentMapper.updateByPrimaryKeySelective(document);
        });
        return CommonResult.success("删除成功");
    }

    /**
     * 更新文档的业务代码
     * @param document
     * @return
     */
    public CommonResult<Object> updateDocs(Document document){
        int code = documentMapper.updateByPrimaryKeySelective(document);
        if(code == 1){
            return CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    /**
     * 添加文档的业务代码
     * @param document
     * @return
     */
    public CommonResult<Object> addDocs(Document document){
        document.setDocumentStatus(1);
        int code = documentMapper.insert(document);
        if(code == 1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
}
