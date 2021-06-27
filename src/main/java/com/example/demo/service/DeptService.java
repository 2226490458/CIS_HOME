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

@Service
public class DeptService {

    @Resource
    private DeptMapper deptMapper;

//    根据部门名称查询
    public CommonResult<Object> getDept(DeptQueryVO queryVO) {
        List<Dept> deptList = deptMapper.listOfDept(queryVO);
        Integer amount = deptMapper.selectDeptAmount(queryVO);
        DeptListDTO listDTO = new DeptListDTO();
        listDTO.setList(deptList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

//    删除
    public CommonResult<Object> deleteDept(DeptDeleteVO deptDeleteVO) {
        List<Integer> ids = deptDeleteVO.getIds();
        ids.forEach(id ->{
            Dept dept = new Dept();
            dept.setDeptId(id);
            dept.setDeptStatus(0);
            deptMapper.updateByPrimaryKeySelective(dept);
        });
        return CommonResult.success("删除成功!");
    }

//    修改
    public CommonResult<Object> updateDept(DeptFixVO deptFixVO) {
        Dept dept = new Dept();
        dept.setDeptId(deptFixVO.getDeptId());
        dept.setDeptName(deptFixVO.getDeptName());// 修改部门名称
        dept.setDeptRemark(deptFixVO.getDeptRemark());// 修改部门描述
        int code = deptMapper.updateByPrimaryKeySelective(dept);
        if (code == 1) {
            return CommonResult.success("修改成功!");
        }
        return CommonResult.fail("修改失败!");
    }

//    添加
    public CommonResult<Object> addDept(DeptAddVO deptAddVO) {
        Dept dept = new Dept();
        dept.setDeptName(deptAddVO.getDeptName());
        dept.setDeptRemark(deptAddVO.getDeptRemark());
        dept.setDeptStatus(1);
        int code = deptMapper.insert(dept);
        if (code == 1) {
            return CommonResult.success("添加成功!");
        }
        return CommonResult.fail("添加失败!");
    }
}
