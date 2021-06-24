package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;
import com.example.demo.vos.emp.EmpDeleteVO;
import com.example.demo.vos.emp.EmpQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 员工管理模块
 */
@RestController
@CrossOrigin
public class EmpMangeController {
    @Resource
    private EmpService empService;

    /**
     * 添加员工
     * @param employee 员工信息
     * @return 结果
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/insertEmployee")
    public CommonResult<Object> insertEmployee(@RequestBody Employee employee){
        employee.setEmployeeStatus(RecordExistEnum.exist.getCode());
        return empService.insertEmployee(employee);
    }

    /**
     * （按需）查询员工
     * @param empQueryVO 员工信息
     * @return 结果
     */
    @GetMapping("/listEmployee")
    public CommonResult<Object> listEmployee(EmpQueryVO empQueryVO){
        return empService.listEmployee(empQueryVO);
    }

    /**
     * 修改员工信息
     * @param employee 员工信息
     * @return 结果
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/modifyEmployee")
    public CommonResult<Object> modifyEmployee(@RequestBody Employee employee){
        return empService.modifyEmployee(employee);
    }

    /**
     * 删除员工
     * @param empDeleteVO 员工ID集合
     * @return 结果
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/deleteEmployee")
    public CommonResult<Object> deleteEmployee(@RequestBody EmpDeleteVO empDeleteVO){
        return empService.deleteEmployee(empDeleteVO);
    }

}
