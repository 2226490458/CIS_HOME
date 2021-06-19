package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.EmpDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.vos.emp.EmpDeleteVO;
import com.example.demo.vos.emp.EmpQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class EmpService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 添加员工
     * @param employee 员工信息
     * @return 结果
     */
    public CommonResult<Object> insertEmployee(Employee employee){
        int code = employeeMapper.insert(employee);
        if (code == 1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
    /**
     * （按需）查询员工
     * @param empQueryVO 员工信息
     * @return 结果
     */
    public CommonResult<Object> listEmployee(EmpQueryVO empQueryVO){
        List<EmpDTO> empDTOS = employeeMapper.listOfEmp(empQueryVO);
        return CommonResult.success(empDTOS);
    }
    /**
     * 修改员工信息
     * @param employee 员工信息
     * @return 结果
     */
    public CommonResult<Object> modifyEmployee(Employee employee){
        int code = employeeMapper.updateByPrimaryKeySelective(employee);
        if (code == 1){
            return CommonResult.success("修改成功");
        }
        return CommonResult.fail("修改失败");
    }

    /**
     * 删除员工们
     * @param empDeleteVO 员工ID集合
     * @return 结果
     */
    public CommonResult<Object> deleteEmployee(EmpDeleteVO empDeleteVO){
        for (Integer id : empDeleteVO.getIds()) {
            int code = employeeMapper.deleteByPrimaryKey(id);
            if (code != 1){
                return CommonResult.fail("删除失败");
            }
        }
        return CommonResult.success("删除成功");
    }

}
