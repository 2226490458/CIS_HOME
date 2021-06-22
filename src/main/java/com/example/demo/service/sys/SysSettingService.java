package com.example.demo.service.sys;

import com.example.demo.common.CommonResult;
import com.example.demo.common.entityEnum.PermEnum;
import com.example.demo.dtos.sys.DeptSettingDTO;
import com.example.demo.dtos.sys.JobSettingDTO;
import com.example.demo.dtos.sys.UserPermDTO;
import com.example.demo.entity.Dept;
import com.example.demo.entity.Job;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.JobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 * 职位配置类
 */
@Service
public class SysSettingService {

    @Resource
    private JobMapper jobMapper;

    @Resource
    private DeptMapper deptMapper;

    /**
     * 获取职位的信息（jobName， id）
     * @return
     */
    public CommonResult<Object> getJobNameAndId() {
        List<Job> jobList = jobMapper.listOfJobNameAndId();
        List<JobSettingDTO> settingDTOList = new ArrayList<>();
        jobList.forEach(job -> {
            JobSettingDTO jobSettingDTO = new JobSettingDTO();
            jobSettingDTO.setJobName(job.getJobName());
            jobSettingDTO.setCode(job.getJobId());
            settingDTOList.add(jobSettingDTO);
        });
        return CommonResult.success(settingDTOList);
    }

    /**
     * 获取部门编号和名称（deptName， id）
     * @return
     */
    public CommonResult<Object> listOfDeptNameAndId() {
        List<Dept> deptList = deptMapper.listOfDeptNameToID();
        List<DeptSettingDTO> settingDTOList = new ArrayList<>();
        deptList.forEach(dept -> {
            DeptSettingDTO deptSettingDTO = new DeptSettingDTO();
            deptSettingDTO.setDeptName(dept.getDeptName());
            deptSettingDTO.setCode(dept.getDeptId());
            settingDTOList.add(deptSettingDTO);
        });
        return CommonResult.success(settingDTOList);
    }

    /**
     * 获取用户权限信息(permName，code)
     * @return
     */
    public CommonResult<Object> listOfUserPermAndCode() {
        List<UserPermDTO> result = new ArrayList<>();
        for (PermEnum perm:PermEnum.values()) {
            UserPermDTO userPermDTO = new UserPermDTO();
            userPermDTO.setPermName(perm.getName());
            userPermDTO.setCode(perm.getCode());
            result.add(userPermDTO);
        }
        return CommonResult.success(result);
    }
}
