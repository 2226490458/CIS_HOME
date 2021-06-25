package com.example.demo.noticeTest;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.NoticeDTO;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.service.NoticeService;
import com.example.demo.vos.notice.NoticeAddVO;
import com.example.demo.vos.notice.NoticeDeleteVO;
import com.example.demo.vos.notice.NoticeFixVO;
import com.example.demo.vos.notice.NoticeQueryVO;
import com.mysql.cj.jdbc.exceptions.NotUpdatable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NoticeServiceTest {
    @Resource
    private NoticeService noticeService;

    @Test
    public void getNoticeTest(){
        NoticeQueryVO queryVO = new NoticeQueryVO();
        queryVO.setNoticeTitle("修改");
        queryVO.setPage(1);
        queryVO.setSize(10);
        System.out.println(queryVO);
        CommonResult<Object> noticeList = noticeService.getNotices(queryVO);
        System.out.println(noticeList.getStatus());
        noticeList.getMessage();
        assert noticeList != null;
        List<NoticeDTO> list = (List<NoticeDTO>) noticeList.getData();
        list.forEach(noticeDTO -> {
            System.out.println(noticeDTO);
        });
    }

    @Test
    public void deleteNoticeTest(){
        NoticeDeleteVO deleteVO = new NoticeDeleteVO();
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        deleteVO.setIds(ids);
        CommonResult<Object> noticeList = noticeService.deleteNotices(deleteVO);

        System.out.println(noticeList.getMessage());
    }

    @Test
    public void updateNoticeTest(){
        NoticeFixVO fixVO= new NoticeFixVO();
        fixVO.setNoticeId(2);
        fixVO.setNoticeTitle("测试");
        fixVO.setNoticeContent("这是测试");
        CommonResult<Object> noticeList= noticeService.updateNotices(fixVO);
        noticeList.getMessage();
    }

    @Test
    public void addNoticesTest(){
        NoticeAddVO addVO=new NoticeAddVO();
        addVO.setUserId(3);
        addVO.setNoticeTitle("添加测试");
        addVO.setNoticeContent("这是添加测试");
        CommonResult<Object> noticeList = noticeService.addNotices(addVO);
        System.out.println(noticeList.getMessage());
    }

}
