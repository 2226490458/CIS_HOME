package com.example.demo.dtos.sys;


/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 * 职位配置类
 */
public class JobSettingDTO {
    private String jobName;
    private Integer code;

    @Override
    public String toString() {
        return "JobSettingDTO{" +
                "jobName='" + jobName + '\'' +
                ", code=" + code +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
