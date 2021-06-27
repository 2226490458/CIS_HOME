package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.DeptService;
import com.example.demo.vos.dept.DeptAddVO;
import com.example.demo.vos.dept.DeptDeleteVO;
import com.example.demo.vos.dept.DeptFixVO;
import com.example.demo.vos.dept.DeptQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 部门管理模块
 */
@RestController
public class DeptMangeController {

    @Resource
    private DeptService deptService;

//    根据部门名称查询
    @GetMapping("/getDept")
    public CommonResult<Object> getDept(DeptQueryVO deptQueryVO) {
        return deptService.getDept(deptQueryVO);
    }

    /**
     * 删除
     * @param deptDeleteVO
     * @return
     */
    @RequiresPermissions("user:admin")
    @PostMapping("/deleteDept")
    public CommonResult<Object> deleteDept(@RequestBody DeptDeleteVO deptDeleteVO) {

        return deptService.deleteDept(deptDeleteVO);
    }

//    修改
    @RequiresPermissions("user:admin")
    @PostMapping("/updateDept")
    public CommonResult<Object> updateDept(@RequestBody DeptFixVO deptFixVO) {

        return deptService.updateDept(deptFixVO);
    }

//    添加
    @RequiresPermissions("user:admin")
    @PostMapping("/addDept")
    public CommonResult<Object> addDept(@RequestBody DeptAddVO deptAddVO) {

        return deptService.addDept(deptAddVO);
    }
}
