package com.example.demo.jobTest;

import com.example.demo.common.CommonResult;
import com.example.demo.service.JobService;
import com.example.demo.vos.job.JobAddVO;
import com.example.demo.vos.job.JobDeleteVO;
import com.example.demo.vos.job.JobFixVO;
import com.example.demo.vos.job.JobQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class JobServiceTest {
    @Resource
    private JobService jobService;


    @Test
    public void addJobsTest() {
//        Job job = new Job();
//        job.setJobName("贝斯手");
//        job.setJobRemark("负责乐器贝斯的人");
//        job.setJobStatus(1);
        JobAddVO jobAddVO = new JobAddVO();
        jobAddVO.setJobName("键盘手");
        jobAddVO.setJobRemark("负责乐器键盘的人");
        CommonResult<Object> code = jobService.addJobs(jobAddVO);
        System.out.println(code.getStatus());
    }

    @Test
    public void getJobsTest() {
        JobQueryVO queryVO = new JobQueryVO();
        queryVO.setJobName("手");
        queryVO.setPage(1);
        queryVO.setSize(10);
        CommonResult<Object> result = jobService.getJobs(queryVO);
        System.out.println(result.getData());
    }

    @Test
    public void updateJobTest() {
//        Job job = new Job();
//        job.setJobId(1);
//        job.setJobRemark("负责主唱额乐器吉他的人");
//        JobFixVO jobFixVO = new JobFixVO();
//        jobFixVO.setJobId(1);
//        CommonResult<Object> code = jobService.updateJobs(jobFixVO);
//        System.out.println(code.getStatus());
    }

    @Test
    public void deleteJobTest() {
        JobDeleteVO jobDeleteVO=new JobDeleteVO();
        ArrayList<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        jobDeleteVO.setIds(ids);
        CommonResult<Object> code = jobService.deleteJobs(jobDeleteVO);
        System.out.println(code.getStatus());
    }
}
