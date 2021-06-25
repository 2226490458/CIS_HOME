package com.example.demo.userTest;


import com.example.demo.common.CommonResult;
import com.example.demo.entity.Cusers;
import com.example.demo.service.UserService;
import com.example.demo.vos.user.UserAddVO;
import com.example.demo.vos.user.UserDeleteVO;
import com.example.demo.vos.user.UserFixVO;
import com.example.demo.vos.user.UserQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void getUserTest(){
        UserQueryVO queryVO = new UserQueryVO();
        queryVO.setUserName("111");
        queryVO.setPage(1);
        queryVO.setSize(10);
        System.out.println(queryVO);
        CommonResult<Object> userList = userService.getUser(queryVO);
        System.out.println(userList.getStatus());
        userList.getMessage();
        assert userList != null;
        List<Cusers> list = (List<Cusers>) userList.getData();
        list.forEach(Cusers ->{
            System.out.println(Cusers);
        });
    }

    @Test
    public void deleteUserTest(){
        UserDeleteVO deleteVO = new UserDeleteVO();
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        deleteVO.setIds(ids);
        CommonResult<Object> userList = userService.deleteUser(deleteVO);

        System.out.println(userList.getMessage());
    }

    @Test
    public void updateUserTest(){
        UserFixVO fixVO = new UserFixVO();
        fixVO.setUserId(2);
        fixVO.setUserName("wx");
        fixVO.setLoginName("12345");
        CommonResult<Object> userList = userService.updateUsers(fixVO);
        userList.getMessage();
    }

    @Test
    public void addUserTest(){
        UserAddVO addVO = new UserAddVO();
        addVO.setEmpId(3);
        addVO.setUserName("ceshi");
        addVO.setLoginName("54321");
        CommonResult<Object> userList = userService.addUsers(addVO);
        System.out.println(userList.getMessage());
    }
}
