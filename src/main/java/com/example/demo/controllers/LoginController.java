package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.LoginService;
import com.example.demo.vos.FaceVO;
import com.example.demo.vos.dept.DeptQueryVO;
import com.example.demo.vos.login.LoginFaceVO;
import com.example.demo.vos.login.LoginVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public CommonResult<Object> loginWithFace(LoginFaceVO faceVO) {
        return loginService.loginWidthFace(faceVO);
    }


    @GetMapping("/logout")
    public CommonResult<Object> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || "".equals(token)) {
            return CommonResult.fail("非法操作");
        }
        return loginService.logout(token);
    }


    @RequiresPermissions("user:common")
    @PostMapping("/face_register")
    public CommonResult<Object> saveFace(FaceVO faceVO) {
        System.out.println(faceVO.getUserId());
        System.out.println(faceVO.getFile().getOriginalFilename());
        return loginService.registerFace(faceVO);
    }


    @RequiresPermissions("user:admin")
    @GetMapping("/test_admin")
    public CommonResult<Object> testPerm() {
        return CommonResult.success("管理员测试成功");
    }

    @RequiresPermissions("user:common")
    @GetMapping("/test_common")
    public CommonResult<Object> testCommon() {
        return CommonResult.success("普通员工测试成功");
    }

}
