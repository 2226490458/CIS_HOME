package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.sys.SysSettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 * 前端配置控制层
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Resource
    private SysSettingService sysSettingService;

    @GetMapping("/job_setting")
    public CommonResult<Object> getJobSetting() {
        return  sysSettingService.getJobNameAndId();
    }

    @GetMapping("/user_perm")
    public CommonResult<Object> getUserPerm() {
        return sysSettingService.listOfUserPermAndCode();
    }

    @GetMapping("/dept_setting")
    public CommonResult<Object> getDeptSettings() {
        return sysSettingService.listOfDeptNameAndId();
    }
}
