package com.example.demo.vos.job;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
public class JobFixVO extends JobAddVO {
    private Integer jobStatus;

    @Override
    public String toString() {
        return "JobFixVO{" +
                "jobStatus=" + jobStatus +
                '}';
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }
}
