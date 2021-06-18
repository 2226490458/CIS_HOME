package com.example.demo.vos.job;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class JobQueryVO {
    private String jobName;

    private String jobRemark;

    @Override
    public String toString() {
        return "JobQueryVO{" +
                "jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobRemark() {
        return jobRemark;
    }

    public void setJobRemark(String jobRemark) {
        this.jobRemark = jobRemark;
    }
}
