package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.vos.PasswordVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 */
@Service
public class PswService {
    @Resource
    private CusersMapper cusersMapper;

    /**
     * 更新用户密码
     * @param passwordVO 新密码
     * @return
     */
    public CommonResult<Object> updateUserPsw(PasswordVO passwordVO) {
        Cusers user = new Cusers();
        Cusers oldUser = cusersMapper.selectByPrimaryKey(passwordVO.getUserId());
        if (oldUser == null) {
            return CommonResult.fail("服务端错误");
        }
        if (!oldUser.getUserPwd().equals(passwordVO.getOldPsw())) {
            return CommonResult.fail("旧密码不正确");
        }
        user.setUserId(passwordVO.getUserId());
        user.setUserPwd(passwordVO.getNewPsw());
        int code = cusersMapper.updateByPrimaryKeySelective(user);
        if (code == 0) {
            return CommonResult.fail("密码修改失败，请稍后再试");
        }
        return CommonResult.success("密码修改成功");
    }
}
