package com.example.demo.userTest;

import com.example.demo.common.entityEnum.PermEnum;
import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.vos.user.UserQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */

@SpringBootTest
public class UserDAOTest {

    @Resource
    private CusersMapper cusersMapper;

    @Test
    public void saveUserTest() {
        Cusers user = new Cusers();
        user.setEmployeeId(3);
        user.setLoginName("baiyusoup");
        user.setUserPwd("123456");
        user.setStatus(PermEnum.admin.getCode());
        user.setUserName("韦其豪");
        user.setFacePath("D://face/baiyu.png");
        user.setFaceUrl("/face/baiyu.png");
        user.setUserStatus(RecordExistEnum.exist.getCode());
        int code =cusersMapper.insert(user);
        System.out.println(code);
    }

    @Test
    public void listOfUserTest() {
        UserQueryVO queryVO = new UserQueryVO();
        queryVO.setUsername("秋山澪");
        queryVO.setPage(1);
        queryVO.setSize(10);
        List<Cusers> userList = cusersMapper.listOfUser(queryVO);
        System.out.println(userList.size());
    }

    @Test
    public void updateUserTest() {
        Cusers user = new Cusers();
        user.setUserId(1);
        user.setUserPwd("happy1+1");
        int code = cusersMapper.updateByPrimaryKeySelective(user);
        System.out.println(code);
    }


    @Test
    public void selectByUsernameTest() {
        Cusers user = cusersMapper.selectByUsername("hello");
        assert user != null;
        System.out.println(user.getLoginName());
    }
}
