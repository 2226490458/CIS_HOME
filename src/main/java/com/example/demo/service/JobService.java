package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.JobListDTO;
import com.example.demo.entity.Job;
import com.example.demo.mapper.JobMapper;
import com.example.demo.vos.job.JobAddVO;
import com.example.demo.vos.job.JobDeleteVO;
import com.example.demo.vos.job.JobFixVO;
import com.example.demo.vos.job.JobQueryVO;
import com.example.demo.vos.user.UserQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class JobService {
    @Resource
    private JobMapper jobMapper;

    /**
     * 分页查询职位信息
     * @param queryVO 查询条件
     * @return
     */
    public CommonResult<Object> getJobs(JobQueryVO queryVO){
        // 1. 分页查询职位
        List<Job> jobList= jobMapper.listOfJob(queryVO);
        // 2. 查询符合查询条件的部门的数量
        int amount = jobMapper.selectJobAmount(queryVO);
        // 3. 封装成DTO
        JobListDTO listDTO = new JobListDTO();
        listDTO.setList(jobList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    /**
     * 删除职位
     * @param deleteVO 删除条件
     * @return
     */
    public CommonResult<Object> deleteJob(JobDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id->{
            Job job = new Job();
            // 设置被删除的职位
            job.setJobId(id);
            job.setJobStatus(0);
            // 调用位置的DAO层的更新方法，将job_status字段设置为0，表示这条记录已删除
            jobMapper.updateByPrimaryKeySelective(job);
        });
        return CommonResult.success("删除成功");
    }

    /**
     * 更新职位
     * @param fixVO 更新信息
     * @return
     */
    public CommonResult<Object> updateJob(JobFixVO fixVO){
        Job job = new Job();
        // 设置要更新的职位编号
        job.setJobId(fixVO.getJobId());
        // 设置要更新的内容，同时注意是否为空，如果为空，要设置为null，方便DAO层的判断
        job.setJobName("".equals(fixVO.getJobName()) ? null : fixVO.getJobName());
        job.setJobRemark("".equals(fixVO.getJobRemark()) ? null : fixVO.getJobRemark());

        // 调用DAO层的更新方法，判断返回值
        int code = jobMapper.updateByPrimaryKeySelective(job);
        if (code==1){
            return CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    /**
     * 添加新职位
     * @param addVO
     * @return
     */
    public CommonResult<Object> addJob(JobAddVO addVO){
        Job job = new Job();
        job.setJobName(addVO.getJobName());
        job.setJobRemark(addVO.getJobRemark());
        job.setJobStatus(1);

        // 调用DAO层的更新方法，并判断返回值
        int code = jobMapper.insert(job);
        if (code==1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
}
