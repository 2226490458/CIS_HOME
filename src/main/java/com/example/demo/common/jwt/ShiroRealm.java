package com.example.demo.common.jwt;

import com.example.demo.common.entityEnum.PermEnum;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.utils.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author 青菜白玉堂
 * @create 2021-06-22
 * shiro自定义认证逻辑
 */
@Component(value = "CustomRealm")
public class ShiroRealm extends AuthorizingRealm {
//    @Resource
//    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private CusersMapper cusersMapper;

    @Value("${custom.jwt.expire_time}")
    private long expireTime;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String token = (String) SecurityUtils.getSubject().getPrincipal();

        String loginName = JwtUtil.getUsername(token);


        if (loginName == null || "".equals(loginName)) {
            return null;
        }

        Cusers user = cusersMapper.selectByUsername(loginName);
        if (user == null) {
            return null;
        }
        // 创建授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        HashSet<String> rootSet = new HashSet<>();
        if (user.getStatus().equals(PermEnum.admin.getCode())) {
            rootSet.add("user:admin");
        }
        rootSet.add("user:common");

        info.setStringPermissions(rootSet);

        return info;
    }


    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();

//        if (Boolean.TRUE.equals(redisTemplate.hasKey(token))) {
//            return null;
//        }

        String loginName = null;
        try {
            loginName = JwtUtil.getUsername(token);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("认证失败");
        }
        if (loginName == null) {
            throw new AuthenticationException("身份已过期，请重新登录");
        }

        return new SimpleAuthenticationInfo(token, token, "CustomRealm");
    }

    /**
     * 刷新jwt令牌
     * @param token
     * @param username
     * @param password
     * @return
     */
//    public boolean jwtTokenRefresh(String token, String username, String password) {
//        String redisToken = (String) redisTemplate.opsForValue().get(token);
//        if (redisToken != null) {
//            if (!JwtUtil.verify(redisToken, username, password)) {
//                String newToken = JwtUtil.sign(username, password);
//                redisTemplate.opsForValue().set(token, newToken, expireTime * 2/ 1000, TimeUnit.SECONDS);
//            }
//            return true;
//        }
//        return false;
//    }
}
