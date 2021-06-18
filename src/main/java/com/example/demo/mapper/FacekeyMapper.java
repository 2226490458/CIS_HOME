package com.example.demo.mapper;

import com.example.demo.entity.Facekey;

public interface FacekeyMapper {
    /**
     * 根据配置编号删除人脸识别配置信息
     * @param faceid 配置信息编号
     * @return 1 表示删除成功； 0 表示删除失败
     */
    int deleteByPrimaryKey(Integer faceid);

    /**
     * 添加人脸识别配置信息
     * @param record 新的配置信息
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Facekey record);

    /**
     * 根据配置编号查询相应的配置
     * @param faceid 配置编号
     * @return 配置信息
     */
    Facekey selectByPrimaryKey(Integer faceid);

    /**
     * 更新配置信息（选择性更新）
     * @param record 新的配置信息
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Facekey record);

}