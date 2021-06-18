package com.example.demo.noticeTest;

import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.dtos.NoticeDTO;
import com.example.demo.entity.Notice;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.vos.notice.NoticeAddVO;
import com.example.demo.vos.notice.NoticeQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
@SpringBootTest
public class NoticeDAOTest {
    @Resource
    private NoticeMapper noticeMapper;

    @Test
    public void saveNoticeTest() {
        Notice notice = new Notice();
        notice.setUserId(3);
        notice.setNoticeTitle("员工之家开张大吉1");
        notice.setNoticeContent("今日是员工之家系统正式编写，鼓掌！papa");
        notice.setNoticeStatus(RecordExistEnum.exist.getCode());
        int code = noticeMapper.insert(notice);
        System.out.println(code);
    }

    @Test
    public void listOfNoticeTest() {
        NoticeQueryVO queryVO = new NoticeQueryVO();
        queryVO.setNoticeTitle("开张大吉");
        queryVO.setPage(1);
        queryVO.setSize(10);
        List<NoticeDTO> noticeList = noticeMapper.listOfNotice(queryVO);
        noticeList.forEach(notice -> {
            System.out.println(notice);
            System.out.println(notice.getNoticeTitle());
        });
    }

    @Test
    public void updateNoticeTest() {
        Notice notice = new Notice();
        notice.setNoticeId(1);
        notice.setNoticeContent("内容修改一下哈， 今日是员工之家系统正式编写，鼓掌！papa");
        int code = noticeMapper.updateByPrimaryKeySelective(notice);
        System.out.println(code);
    }
}
