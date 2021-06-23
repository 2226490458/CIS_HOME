package com.example.demo.common.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 青菜白玉堂
 * @create 2021-06-22
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
