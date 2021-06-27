package com.example.demo.mapper;

import com.example.demo.entity.Document;
import com.example.demo.vos.doc.DocQueryVO;

import java.util.List;

public interface DocumentMapper {
    /**
     * 根据文档编号删除某篇文档
     * @param documentId 文档编号
     * @return 1 表示删除成功； 0 表示删除失败
     */
    int deleteByPrimaryKey(Integer documentId);

    /**
     * 添加文档（完整信息）
     * @param record 信息完整的文档数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Document record);

    /**
     * 添加文档（不完整信息）
     * @param record 信息不完整的文档数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insertSelective(Document record);

    /**
     * 根据文档编号查询某篇文档
     * @param documentId 文档编号
     * @return 某篇文档
     */
    Document selectByPrimaryKey(Integer documentId);

    /**
     * 分页查询文档
     * @param query 查询条件
     * @return 指定页的文档数据
     */
    List<Document> listOfDocument(DocQueryVO query);


    /**
     * 查询文档总量
     * @param queryVO
     * @return
     */
    int selectDocAmount(DocQueryVO queryVO);
    /**
     * 更新文档（选择性更新）
     * @param record 要更新的文档数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * 更新文档（全部更新）
     * @param record 要更新的文档
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKey(Document record);
}