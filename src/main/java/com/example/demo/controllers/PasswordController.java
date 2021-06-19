package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.PswService;
import com.example.demo.service.UserService;
import com.example.demo.vos.PasswordVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 修改密码管理模块
 */
@RestController
public class PasswordController {
    @Resource
    private PswService pswService;

    @PostMapping("/fix_psw")
    public CommonResult<Object> updateUserPsw(@RequestBody PasswordVO passwordVO) {
        return pswService.updateUserPsw(passwordVO);
    }
}
