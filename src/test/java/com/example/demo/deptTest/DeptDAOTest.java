package com.example.demo.deptTest;

import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.vos.dept.DeptFixVO;
import com.example.demo.vos.dept.DeptQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
@SpringBootTest
public class DeptDAOTest {
    @Resource
    private DeptMapper deptMapper;

    @Test
    public void saveDeptTest() {
        Dept dept = new Dept();
        dept.setDeptName("轻音部");
        dept.setDeptRemark("这是一个搞欢快音乐的部门");
        dept.setDeptStatus(1);
        int code = deptMapper.insert(dept);
        System.out.println(code);
        System.out.println(dept);
    }

    @Test
    public void listOfDeptTest() {
        DeptQueryVO queryVO = new DeptQueryVO();
        queryVO.setDeptName("轻音部");
        queryVO.setPage(1);
        queryVO.setSize(10);
        List<Dept> deptList = deptMapper.listOfDept(queryVO);
        System.out.println(deptList.size());
        deptList.forEach(System.out::println);
    }

    @Test
    public void updateDeptTest() {
        Dept dept = new Dept();
        dept.setDeptId(1);
        dept.setDeptName("运营部");
        dept.setDeptRemark("这是一个搞运营的部门");
        int code = deptMapper.updateByPrimaryKeySelective(dept);
        System.out.println(code);
    }

    @Test
    public void deleteDeptTest() {
        System.out.println("只有假删除，因此只需要调用update方法即可");
    }
}
