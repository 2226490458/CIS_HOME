package com.example.demo.empTest;

import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.common.entityEnum.SexEnum;
import com.example.demo.dtos.EmpDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.vos.emp.EmpQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
@SpringBootTest
public class EmpDAOTest {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void saveEmpTest() {
        Employee employee = new Employee();
        employee.setDeptId(1);
        employee.setJobId(1);
        employee.setEmployeeName("韦其豪");
        employee.setCardId("452122200008210002");
        employee.setAddress("重庆理工大学");
        employee.setPostCard("530303");
        employee.setTel("077-123455");
        employee.setPhone("12345678910");
        employee.setQqNum("1575727840");
        employee.setEmail("1575727840@qq.com");
        employee.setSex(SexEnum.Female.getCode());
        employee.setParty("共青团员");
        employee.setBirthday(new Date());
        employee.setRace("汉族");
        employee.setEducation("本科");
        employee.setSpeciality("计算机");
        employee.setHobby("敲代码");
        employee.setRemark("傻逼一个");
        employee.setEmployeeStatus(RecordExistEnum.exist.getCode());

        int code = employeeMapper.insert(employee);
        System.out.println(code);
    }

    @Test
    public void listOfEmpTest() {
        EmpQueryVO queryVO = new EmpQueryVO();
        queryVO.setDeptId(1);
        queryVO.setJobId(1);
        queryVO.setPage(1);
        queryVO.setSize(10);
        queryVO.setSex(SexEnum.Female.getCode());
        List<EmpDTO> empDTOList = employeeMapper.listOfEmp(queryVO);
        empDTOList.forEach(empDTO -> {
            System.out.println(empDTO);
            System.out.println(empDTO.getEmployeeName());
        });
    }

    @Test
    public void updateEmpTest() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setRemark("害羞胆小，做事认真，成绩优秀");
        int code = employeeMapper.updateByPrimaryKeySelective(employee);
        System.out.println(code);
    }
}
