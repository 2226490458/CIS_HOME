package com.example.demo.empTest;

import com.example.demo.common.CommonResult;
import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;
import com.example.demo.vos.emp.EmpDeleteVO;
import com.example.demo.vos.emp.EmpQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年6月20日
 */
@SpringBootTest
public class EmpServiceTest {
    @Resource
    EmpService empService;

    @Test
    public void insertEmployeeTest(){
        Employee employee = new Employee();
        employee.setEmployeeName("测试员");
        employee.setDeptId(1);
        employee.setJobId(1);
        employee.setEmployeeStatus(RecordExistEnum.exist.getCode());
        CommonResult<Object> objectCommonResult = empService.insertEmployee(employee);
        System.out.println(objectCommonResult.getMessage());
    }
    @Test
    public void listEmployeeTest(){
        EmpQueryVO empQueryVO = new EmpQueryVO();
        CommonResult<Object> objectCommonResult = empService.listEmployee(empQueryVO);
        System.out.println(objectCommonResult.getData());
    }
    @Test
    public void modifyEmployeeTest(){
        Employee employee = new Employee();
        employee.setEmployeeId(8);
        employee.setBirthday(new Date());
        employee.setCardId("452122200008210002");
        CommonResult<Object> objectCommonResult = empService.modifyEmployee(employee);
        System.out.println(objectCommonResult.getMessage());
    }
    @Test
    public void deleteEmployeeTest(){
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        EmpDeleteVO empDeleteVO = new EmpDeleteVO();
        empDeleteVO.setIds(ids);
        CommonResult<Object> objectCommonResult = empService.deleteEmployee(empDeleteVO);
        System.out.println(objectCommonResult.getMessage());
    }
}
