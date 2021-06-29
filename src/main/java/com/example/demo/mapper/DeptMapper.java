package com.example.demo.mapper;

import com.example.demo.entity.Dept;
import com.example.demo.vos.dept.DeptQueryVO;

import java.util.List;

public interface DeptMapper {

    /**
     * 添加部门 （信息完整）
     * @param record 信息完整的部门数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Dept record);


    /**
     * 根据部门编号查询某个部门信息
     * @param deptId 部门编号
     * @return 某个部门的信息数据
     */
    Dept selectByPrimaryKey(Integer deptId);

    /**
     * 分页查询部门信息
     * @param query 查询条件
     * @return 某页的部门信息数据
     */
    List<Dept> listOfDept(DeptQueryVO query);

    /**
     * 查询部门名和id
     * @return
     */
    List<Dept> listOfDeptNameToID();

    /**
     * 查询部门总数
     * @param query
     * @return
     */
    int selectDeptAmount(DeptQueryVO query);

    /**
     * 更新部门信息 （选择性更新）
     * @param record 要更新的部门信息
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Dept record);

}