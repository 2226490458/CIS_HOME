package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.dtos.NoticeDTO;
import com.example.demo.dtos.NoticeListDTO;
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

    /**
     * 分页查询公告
     * @param queryVO 查询条件
     * @return
     */
    public CommonResult<Object> getNotices(NoticeQueryVO queryVO){
        // 分页查询公告
        List<NoticeDTO> noticeList = noticeMapper.listOfNotice(queryVO);
        // 获取符合查询条件的公告数量
        int amount = noticeMapper.selectNoticeAmount(queryVO);

        // 将数据放到DTO
        NoticeListDTO listDTO = new NoticeListDTO();
        listDTO.setList(noticeList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    /**
     * 删除公告
     * @param deleteVO 删除条件
     * @return
     */
    public CommonResult<Object> deleteNotices(NoticeDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id ->{
            Notice notice = new Notice();
            // 设置被删除的公告编号
            notice.setNoticeId(id);
            notice.setNoticeStatus(0);
            // 调用公告模块的DAO层的更新方法，修改notice_status字段为0
            noticeMapper.updateByPrimaryKeySelective(notice);
        });
        return CommonResult.success("删除成功");
    }

    /**
     * 更新公告
     * @param fixVO 要更新的公告信息
     * @return
     */
    public CommonResult<Object> updateNotices(NoticeFixVO fixVO){
        Notice notice = new Notice();
        notice.setNoticeId(fixVO.getNoticeId());
        // 设置要更新的公告信息，同时需要判断是否有空，如果有空，设置为null，方便DAO的判断
        if (fixVO.getNoticeTitle() != null && !"".equals(fixVO.getNoticeTitle())) {
            notice.setNoticeTitle(fixVO.getNoticeTitle());
        }
        if (fixVO.getNoticeContent() != null && !"".equals(fixVO.getNoticeContent())) {
            notice.setNoticeContent(fixVO.getNoticeContent());
        }
        // 调用DAO的更新方法，并判断返回值
        int code = noticeMapper.updateByPrimaryKeySelective(notice);
        if(code==1){
            return CommonResult.success("更新成功");
        }
        return  CommonResult.success("失败");
    }

    /**
     * 添加新公告
     * @param addVO
     * @return
     */
    public CommonResult<Object> addNotices(NoticeAddVO addVO){
        if ("".equals(addVO.getNoticeContent()) || "".equals(addVO.getNoticeTitle())) {
            return CommonResult.fail("输入内容不能有空");
        }
        Notice notice= new Notice();
        notice.setUserId(addVO.getUserId());
        notice.setNoticeStatus(1);
        notice.setNoticeTitle(addVO.getNoticeTitle());
        notice.setNoticeContent(addVO.getNoticeContent());
        // 调用DAO层的添加方法，并判断返回值
        int code = noticeMapper.insert(notice);
        if(code==1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.success("失败");
    }
}
