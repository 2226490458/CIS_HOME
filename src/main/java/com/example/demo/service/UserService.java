package com.example.demo.service;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.GusersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class UserService {
    @Resource
    private GusersMapper userMapper;
}
