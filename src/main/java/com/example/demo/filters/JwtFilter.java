package com.example.demo.filters;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.CommonResult;
import com.example.demo.common.jwt.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;


import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 青菜白玉堂
 * @create 2021-06-22
 * jwt过滤器
 */

public class JwtFilter extends BasicHttpAuthenticationFilter implements Filter {

    /**
     * 执行登录
     * @param request 请求
     * @param response 响应
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");

        JwtToken jwtToken = new JwtToken(token);
        try {
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
    }

    /**
     * 登录认证
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("jwt验证失败");
            return false;
        }
    }

    /**
     * 认证失败
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        CommonResult<Object> result = CommonResult.fail("认证失败");
        Object parse = JSONObject.toJSON(result);
        response.getWriter().print(parse);
        return super.onAccessDenied(request, response);
    }
}

