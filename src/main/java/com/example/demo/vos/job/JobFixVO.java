package com.example.demo.vos.job;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class JobFixVO extends JobAddVO {
    private String jobName;
    private String jobRemark;
    private Integer jobId;//新增

    @Override
    public String toString() {
        return "JobFixVO{" +
                "jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                ", jobId=" + jobId +
                '}';
    }

    @Override
    public String getJobName() {
        return jobName;
    }

    @Override
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String getJobRemark() {
        return jobRemark;
    }

    @Override
    public void setJobRemark(String jobRemark) {
        this.jobRemark = jobRemark;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
