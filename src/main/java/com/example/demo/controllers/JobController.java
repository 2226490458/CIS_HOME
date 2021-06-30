package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.JobService;
import com.example.demo.vos.job.JobAddVO;
import com.example.demo.vos.job.JobDeleteVO;
import com.example.demo.vos.job.JobFixVO;
import com.example.demo.vos.job.JobQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    /**
     * 分页查询职位
     * @param queryVO 查询条件
     * @return
     */
    @GetMapping("/getjobs")
    public CommonResult<Object> getJobs(JobQueryVO queryVO){
        return jobService.getJobs(queryVO);
    }

    /**
     * 删除职位
     * @param deleteVO 被删除职位编号信息
     * @return
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/deleteJob")
    public CommonResult<Object> deleteJob(@RequestBody JobDeleteVO deleteVO){
        return jobService.deleteJob(deleteVO);
    }

    /**
     * 更新职位
     * @param fixVO 更新信息
     * @return
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/updateJob")
    public CommonResult<Object> updateJob(@RequestBody JobFixVO fixVO){
        return jobService.updateJob(fixVO);
    }

    /**
     * 添加职位
     * @param addVO
     * @return
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/addJob")
    public CommonResult<Object> addJob(@RequestBody JobAddVO addVO)
    {

        return jobService.addJob(addVO);
    }


}
