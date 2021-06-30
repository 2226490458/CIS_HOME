package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.UserService;
import com.example.demo.vos.notice.NoticeAddVO;
import com.example.demo.vos.user.UserAddVO;
import com.example.demo.vos.user.UserDeleteVO;
import com.example.demo.vos.user.UserFixVO;
import com.example.demo.vos.user.UserQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 用户管理模块
 */
@RestController
public class UserMangeController {
    @Resource
    private UserService userService;

    @GetMapping("/getUsers")
    public CommonResult<Object> getUsers(UserQueryVO queryVO){
        return userService.getUsers(queryVO);
    }

    @RequiresPermissions("user:admin")
    @PostMapping("/deleteUser")
    public CommonResult<Object> deleteUser(@RequestBody UserDeleteVO deleteVO){
        return  userService.deleteUser(deleteVO);
    }

    @RequiresPermissions("user:admin")
    @PostMapping("/updateUser")
    public  CommonResult<Object> updateUser(@RequestBody UserFixVO fixVO){
        return  userService.updateUsers(fixVO);
    }


    @RequiresPermissions("user:admin")
    @PostMapping("/addUser")
    public CommonResult<Object> addUser(@RequestBody UserAddVO addVO){
        return  userService.addUser(addVO);
    }
}
