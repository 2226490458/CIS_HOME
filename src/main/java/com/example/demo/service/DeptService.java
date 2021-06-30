package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.DeptListDTO;
import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.vos.dept.DeptAddVO;
import com.example.demo.vos.dept.DeptDeleteVO;
import com.example.demo.vos.dept.DeptFixVO;
import com.example.demo.vos.dept.DeptQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 部门模块的Service层
 * 负责部门模块的业务逻辑处理
 */
@Service
public class DeptService {

    // 注入部门的DAO对象
    @Resource
    private DeptMapper deptMapper;

    /**
     * 分页查询部门
     * @param queryVO 查询条件
     * @return 部门信息
     */
    public CommonResult<Object> getDepts(DeptQueryVO queryVO) {
        // 1. 分页查询部门数据
        List<Dept> deptList = deptMapper.listOfDept(queryVO);

        // 2. 获取符合查询条件的部门数量
        Integer amount = deptMapper.selectDeptAmount(queryVO);

        // 3. 将数据包装成DTO
        DeptListDTO listDTO = new DeptListDTO();
        listDTO.setList(deptList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    /**
     * 删除部门，实际是修改部门数据dept_status字段
     * @param deptDeleteVO 删除条件
     * @return 操作信息
     */
    public CommonResult<Object> deleteDept(DeptDeleteVO deptDeleteVO) {
        List<Integer> ids = deptDeleteVO.getIds();
        ids.forEach(id ->{
            Dept dept = new Dept();
            // 设置要删除的部门的编号
            dept.setDeptId(id);
            dept.setDeptStatus(0);
            // 调用部门DAO的更新方法，修改dept_status字段
            deptMapper.updateByPrimaryKeySelective(dept);
        });
        return CommonResult.success("删除成功!");
    }

    /**
     * 修改部门信息
     * @param deptFixVO 修改信息
     * @return 操作信息
     */
    public CommonResult<Object> updateDept(DeptFixVO deptFixVO) {
        Dept dept = new Dept();
        // 1. 设置要修改的部门的编号
        dept.setDeptId(deptFixVO.getDeptId());
        // 2. 设置要修改的部门名称
        if (deptFixVO.getDeptName() != null && !"".equals(deptFixVO.getDeptName())) {
            dept.setDeptName(deptFixVO.getDeptName());
        }
        // 3. 设置新的部门描述
        if (deptFixVO.getDeptRemark() != null && !"".equals(deptFixVO.getDeptRemark())) {
            dept.setDeptRemark(deptFixVO.getDeptRemark());
        }
        // 4. 调用DAO的更新方法，判断返回值
        int code = deptMapper.updateByPrimaryKeySelective(dept);
        if (code == 1) {
            return CommonResult.success("修改成功!");
        }
        return CommonResult.fail("修改失败!");
    }

    /**
     * 添加新部门
     * @param deptAddVO 新部门信息
     * @return 操作的信息
     */
    public CommonResult<Object> addDept(DeptAddVO deptAddVO) {
        Dept dept = new Dept();
        // 设置新部门
        dept.setDeptRemark(deptAddVO.getDeptRemark());
        dept.setDeptName(deptAddVO.getDeptName());
        dept.setDeptStatus(1);
        // 调用DAO层的添加方法，判断返回值
        int code = deptMapper.insert(dept);
        if (code == 1) {
            return CommonResult.success("添加成功!");
        }
        return CommonResult.fail("添加失败!");
    }
}
