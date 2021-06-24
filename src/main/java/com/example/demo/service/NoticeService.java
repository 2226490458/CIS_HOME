package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.NoticeDTO;
import com.example.demo.entity.Cusers;
import com.example.demo.entity.Notice;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.vos.notice.NoticeAddVO;
import com.example.demo.vos.notice.NoticeDeleteVO;
import com.example.demo.vos.notice.NoticeFixVO;
import com.example.demo.vos.notice.NoticeQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    public CommonResult<Object> getNotices(NoticeQueryVO queryVO){
        List<NoticeDTO> noticeList = noticeMapper.listOfNotice(queryVO);
        return CommonResult.success(noticeList);
    }

    public CommonResult<Object> deleteNotices(NoticeDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id ->{
            Notice notice = new Notice();
            notice.setNoticeId(id);
            notice.setNoticeStatus(0);
            noticeMapper.updateByPrimaryKeySelective(notice);
        });
        return CommonResult.success("删除成功");
    }

    public CommonResult<Object> updateNotices(NoticeFixVO fixVO){
        Notice notice = new Notice();
        notice.setNoticeId(fixVO.getNoticeId());
        notice.setNoticeTitle(fixVO.getNoticeTitle());
        notice.setNoticeContent(fixVO.getNoticeContent());
        int code = noticeMapper.updateByPrimaryKeySelective(notice);
        if(code==1){
            return CommonResult.success("更新成功");
        }
        else
            return  CommonResult.success("失败");
    }

    public CommonResult<Object> addNotices(NoticeAddVO addVO){
        Notice notice= new Notice();
        notice.setUserId(addVO.getUserId());
        notice.setNoticeStatus(1);
        notice.setNoticeTitle(addVO.getNoticeTitle());
        notice.setNoticeContent(addVO.getNoticeContent());
        int code = noticeMapper.insert(notice);
        if(code==1){
            return CommonResult.success("添加成功");
        }
        else
            return  CommonResult.success("失败");
    }
}
