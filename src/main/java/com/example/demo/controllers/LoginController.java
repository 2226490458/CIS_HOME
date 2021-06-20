package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.LoginService;
import com.example.demo.vos.FaceVO;
import com.example.demo.vos.dept.DeptQueryVO;
import com.example.demo.vos.login.LoginFaceVO;
import com.example.demo.vos.login.LoginVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 登录管理模块
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public CommonResult<Object> login(@RequestBody LoginVO loginVO) {
        System.out.println(loginVO);
        return loginService.loginWithNameAndPsw(loginVO);
    }

    @PostMapping("/face_login")
    public CommonResult<Object> loginWithFace(@RequestBody LoginFaceVO faceVO) {
        System.out.println(faceVO);
        return loginService.loginWidthFace(faceVO);
    }

    @PostMapping("/face_register")
    public CommonResult<Object> saveFace(FaceVO faceVO) {
        System.out.println(faceVO.getUserId());
        System.out.println(faceVO.getFile().getOriginalFilename());
        return loginService.registerFace(faceVO);
    }
}
