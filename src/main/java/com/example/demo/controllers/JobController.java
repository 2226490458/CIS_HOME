package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.JobService;
import com.example.demo.vos.job.JobAddVO;
import com.example.demo.vos.job.JobDeleteVO;
import com.example.demo.vos.job.JobFixVO;
import com.example.demo.vos.job.JobQueryVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 职位管理模块
 */
@RestController
public class JobController {
    @Resource
    private JobService jobService;

    @GetMapping("/getjobs")
    public CommonResult<Object> getJobs(JobQueryVO queryVO){
        return jobService.getJobs(queryVO);
    }

    @PostMapping("/deleteJob")
    public CommonResult<Object> deleteJob(@RequestBody JobDeleteVO deleteVO){
        return jobService.deleteJobs(deleteVO);
    }

    @PostMapping("/updateJob")
    public CommonResult<Object> updateJob(@RequestBody JobFixVO fixVO){
        return jobService.updateJobs(fixVO);
    }

    @PostMapping("/AddJob")
    public CommonResult<Object> addJob(@RequestBody JobAddVO addVO)
    {

        return jobService.addJobs(addVO);
    }


}
