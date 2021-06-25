package com.example.demo.controllers;

import com.example.demo.common.CommonResult;
import com.example.demo.service.NoticeService;
import com.example.demo.vos.notice.NoticeAddVO;
import com.example.demo.vos.notice.NoticeDeleteVO;
import com.example.demo.vos.notice.NoticeFixVO;
import com.example.demo.vos.notice.NoticeQueryVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 * 公告管理模块
 */
@RestController
public class NoticeMangeController {
    @Resource
    private NoticeService noticeService;

    @GetMapping("/getNotice")
    public CommonResult<Object> getNotices(NoticeQueryVO queryVO){
        return noticeService.getNotices(queryVO);
    }

    @RequiresPermissions("user:admin")
    @PostMapping("/deleteNotice")
    public CommonResult<Object> deleteNotices(@RequestBody NoticeDeleteVO deleteVO){
        return noticeService.deleteNotices(deleteVO);
    }

    @RequiresPermissions("user:admin")
    @PostMapping("/updateNotice")
    public CommonResult<Object> updateNotices(@RequestBody NoticeFixVO fixVO){
        return noticeService.updateNotices(fixVO);
    }

    @RequiresPermissions("user:admin")
    @PostMapping("/addNotice")
    public CommonResult<Object> addNotices(@RequestBody NoticeAddVO addVO){
        return  noticeService.addNotices(addVO);
    }

}
