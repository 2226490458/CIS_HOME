package com.example.demo.service;

import com.example.demo.mapper.JobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class JobService {
    @Resource
    private JobMapper jobMapper;
}
