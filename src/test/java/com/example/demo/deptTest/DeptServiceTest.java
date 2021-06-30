package com.example.demo.deptTest;

import com.example.demo.common.CommonResult;
import com.example.demo.service.DeptService;
import com.example.demo.vos.dept.DeptAddVO;
import com.example.demo.vos.dept.DeptDeleteVO;
import com.example.demo.vos.dept.DeptFixVO;
import com.example.demo.vos.dept.DeptQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DeptServiceTest {
    @Resource
    private DeptService deptService;

    // 查找测试
    @Test
    public void getDeptTest() {
        DeptQueryVO deptQueryVO = new DeptQueryVO();
        deptQueryVO.setDeptName("研发部");
        deptQueryVO.setPage(1);
        deptQueryVO.setSize(10);
        CommonResult<Object> flag = deptService.getDepts(deptQueryVO);
        System.out.println(flag.getStatus());// 获得业务状态码 status = 200
    }

    // 删除测试
    @Test
    public void deleteDeptTest() {
        DeptDeleteVO deptDeleteVO = new DeptDeleteVO();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        deptDeleteVO.setIds(list);
        CommonResult<Object> flag = deptService.deleteDept(deptDeleteVO);
        System.out.println(flag.getStatus());
    }

    // 修改测试
    @Test
    public void updateDeptTest() {
        DeptFixVO deptFixVO = new DeptFixVO();
        deptFixVO.setDeptId(2);
        deptFixVO.setDeptName("更新测试");
        deptFixVO.setDeptRemark("更新测试更新测试");
        CommonResult<Object> flag = deptService.updateDept(deptFixVO);
        System.out.println(flag.getStatus());
    }

    // 添加测试
    @Test
    public void addDept() {
        DeptAddVO deptAddVO = new DeptAddVO();
        deptAddVO.setDeptName("添加测试");
        deptAddVO.setDeptRemark("添加测试添加测试");
        CommonResult<Object> flag = deptService.addDept(deptAddVO);
        System.out.println(flag.getStatus());
    }

}
