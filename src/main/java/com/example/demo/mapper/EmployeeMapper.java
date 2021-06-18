package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.vos.emp.EmpQueryVO;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据员工编号删除某位员工
     * @param jobId 员工编号
     * @return 1 表示删除成功； 0 表示删除失败
     */
    int deleteByPrimaryKey(Integer jobId);

    /**
     * 添加员工（完整员工信息）
     * @param record 完整的员工信息数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Employee record);

    /**
     * 添加员工（不完整的员工信息）
     * @param record 不完整的员工信息
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insertSelective(Employee record);


    /**
     * 根据员工编号查寻某位员工信息
     * @param jobId 员工编号
     * @return 某位员工信息
     */
    Employee selectByPrimaryKey(Integer jobId);

    /**
     * 分页查询员工信息
     * @param query 查询条件
     * @return 指定页的员工信息数据
     */
    List<Employee> listOfEmp(EmpQueryVO query);

    /**
     * 更新员工信息（选择性更新）
     * @param record 要更新的员工信息数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Employee record);


}