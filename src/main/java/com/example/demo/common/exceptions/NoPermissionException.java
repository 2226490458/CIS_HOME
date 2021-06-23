package com.example.demo.common.exceptions;

import com.example.demo.common.CommonResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 青菜白玉堂
 * @create 2021-06-23
 */
@RestControllerAdvice
public class NoPermissionException {

    @ExceptionHandler(UnauthorizedException.class)
    public CommonResult<Object> handleShiroException(UnauthorizedException e) {
        return CommonResult.fail(e.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    public CommonResult<Object> authorizationException(AuthorizationException e) {
        return CommonResult.fail(e.getMessage());
    }
}
