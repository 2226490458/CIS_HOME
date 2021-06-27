package com.example.demo.vos.job;

import com.example.demo.common.Page;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class JobQueryVO extends Page {
    private String jobName;


    @Override
    public String toString() {
        return "JobQueryVO{" +
                "jobName='" + jobName + '\'' +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        if (jobName == null || "".equals(jobName)) {
            this.jobName = null;
        } else {
            this.jobName = "%" + jobName + "%";
        }
    }
}
