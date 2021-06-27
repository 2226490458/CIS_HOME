package com.example.demo.mapper;

import com.example.demo.entity.Job;
import com.example.demo.vos.job.JobQueryVO;

import java.util.List;

public interface JobMapper {
    /**
     * 根据职位编号删除职位
     * @param jobId 职位编号
     * @return 1 表示删除成功； 0 表示删除失败
     */
    int deleteByPrimaryKey(Integer jobId);

    /**
     * 添加职位 (信息完整)
     * @param record 信息完整的职位数据
     * @return 1 表示添加成功； 0 表示删除失败
     */
    int insert(Job record);

    /**
     * 添加职位 （信息不完整）
     * @param record 信息不完整的职位数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insertSelective(Job record);

    /**
     * 根据职位编号查询某个职位信息
     * @param jobId 职位编号
     * @return 某个职位信息
     */
    Job selectByPrimaryKey(Integer jobId);

    /**
     * 分页查询职位信息
     * @param query 查询条件
     * @return 某页的职位数据
     */
    List<Job> listOfJob(JobQueryVO query);

    /**
     * 查询所有职位
     * @return
     */
    List<Job> listOfJobNameAndId();

    /**
     * 查职位总量
     * @return
     */
    int selectJobAmount(JobQueryVO queryVO);

    /**
     * 更新职位信息（选择性更新）
     * @param record 要更新的职位信息数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Job record);

    /**
     * 更新职位信息（全部更新）
     * @param record 更新的职位信息数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKey(Job record);
}