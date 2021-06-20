package com.example.demo.accountTest;

import com.example.demo.common.CommonResult;
import com.example.demo.service.LoginService;
import com.example.demo.vos.login.LoginVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-20
 * 测试Service层的登录功能，修改密码功能和人脸注册功能
 */
@SpringBootTest
public class AccountServiceTest {
    @Resource
    private LoginService loginService;

    @Test
    public void loginWithNameAndPswTest() {
        LoginVO loginVO = new LoginVO();
        loginVO.setUsername("hello");
        loginVO.setPassword("123456");
        CommonResult<Object> result = loginService.loginWithNameAndPsw(loginVO);
        System.out.println(result.getStatus());
        assert result.getData() != null;
    }

    @Test
    public void loginWidthFaceTest() {
        System.out.println("未完成");
    }

    @Test
    public void registerFaceTest() {
        System.out.println("先留着");
    }
}
