package com.example.demo.jobTest;

import com.example.demo.entity.Job;
import com.example.demo.mapper.JobMapper;
import com.example.demo.vos.job.JobAddVO;
import com.example.demo.vos.job.JobQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
@SpringBootTest
public class JobDAOTest {
    @Resource
    private JobMapper jobMapper;


    @Test
    public void saveJobTest() {
        Job job = new Job();
        job.setJobName("贝斯手");
        job.setJobRemark("负责乐器贝斯的人");
        job.setJobStatus(1);
        int code = jobMapper.insert(job);
        System.out.println(code);
    }

    @Test
    public void listOfJobTest() {
        JobQueryVO queryVO = new JobQueryVO();
        queryVO.setJobName("手");
        queryVO.setPage(1);
        queryVO.setSize(10);
        List<Job> jobList = jobMapper.listOfJob(queryVO);
        System.out.println(jobList.size());
    }

    @Test
    public void listOfJobNameAndId() {
        List<Job> jobList = jobMapper.listOfJobNameAndId();
        jobList.forEach(job -> {
            System.out.println(job.getJobId());
            System.out.println(job.getJobName());
        });
    }

    @Test
    public void updateJobTest() {
        Job job = new Job();
        job.setJobId(1);
        job.setJobRemark("负责主唱额乐器吉他的人");
        int code = jobMapper.updateByPrimaryKeySelective(job);
        System.out.println(code);
    }

    @Test
    public void deleteJobTest() {
        System.out.println("假删除");
    }
}
