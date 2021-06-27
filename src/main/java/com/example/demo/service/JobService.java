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

    public CommonResult<Object> getJobs(JobQueryVO queryVO){
        List<Job> jobList= jobMapper.listOfJob(queryVO);
        int amount = jobMapper.selectJobAmount(queryVO);
        JobListDTO listDTO = new JobListDTO();
        listDTO.setList(jobList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    public CommonResult<Object> deleteJobs(JobDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id->{
            Job job = new Job();
            job.setJobId(id);
            job.setJobStatus(0);
            jobMapper.updateByPrimaryKeySelective(job);
        });
        return CommonResult.success("删除成功");
    }

    public CommonResult<Object> updateJobs(JobFixVO fixVO){
        Job job = new Job();
        job.setJobId(fixVO.getJobId());
        job.setJobName(fixVO.getJobName().equals("") ? null : fixVO.getJobName());
        job.setJobRemark(fixVO.getJobRemark().equals("") ? null : fixVO.getJobRemark());
        int code = jobMapper.updateByPrimaryKeySelective(job);
        if (code==1){
            return CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    public CommonResult<Object> addJobs(JobAddVO addVO){
        Job job = new Job();
        job.setJobName(addVO.getJobName());
        job.setJobRemark(addVO.getJobRemark());
        job.setJobStatus(1);
        int code = jobMapper.insert(job);
        if (code==1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
}
