package com.example.demo.sysTest;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.sys.DeptSettingDTO;
import com.example.demo.dtos.sys.JobSettingDTO;
import com.example.demo.dtos.sys.UserPermDTO;
import com.example.demo.entity.Dept;
import com.example.demo.service.sys.SysSettingService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-20
 */
@SpringBootTest
public class SysSettingTest {
    @Resource
    private SysSettingService sysSettingService;

    @Test
    public void getJobNameToIDTest() {
        CommonResult<Object> jobNameAndID = sysSettingService.getJobNameAndId();
        List<JobSettingDTO> lists = (List<JobSettingDTO>)jobNameAndID.getData();
        lists.forEach(job -> {
            System.out.println(job.getJobName());
            System.out.println(job.getCode());
        });
    }

    @Test
    public void listOfDeptNameAndIdTest() {
        CommonResult<Object> deptNameAndId = sysSettingService.listOfDeptNameAndId();
        List<DeptSettingDTO> list = (List<DeptSettingDTO>)deptNameAndId.getData();
        list.forEach(System.out::println);
    }

    @Test
    public void listOfUserPermAndCodeTest() {
        CommonResult<Object> userPerm = sysSettingService.listOfUserPermAndCode();
        List<UserPermDTO> list = (List<UserPermDTO>)userPerm.getData();
        list.forEach(System.out::println);
    }
}
