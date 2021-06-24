package com.example.demo.service;

import com.example.demo.common.CommonResult;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.vos.user.UserAddVO;
import com.example.demo.vos.user.UserDeleteVO;
import com.example.demo.vos.user.UserFixVO;
import com.example.demo.vos.user.UserQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class UserService {
    @Resource
    private CusersMapper userMapper;

    public CommonResult<Object> getUser(UserQueryVO queryVO){
        List<Cusers> cusersList = userMapper.listOfUser(queryVO);
        return CommonResult.success(cusersList);
    }

    public  CommonResult<Object> deleteUser(UserDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id ->{
            Cusers cusers = new Cusers();
            cusers.setUserId(id);
            cusers.setUserStatus(0);
            userMapper.updateByPrimaryKeySelective(cusers);
        });
        return CommonResult.success("删除成功");
    }

    public  CommonResult<Object> updateUsers(UserFixVO fixVO){
        Cusers cusers = new Cusers();
        cusers.setUserId(fixVO.getUserId());
        cusers.setLoginName(fixVO.getLoginName());
        int code = userMapper.updateByPrimaryKeySelective(cusers);
        if(code==1){
            return  CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    public CommonResult<Object> addUsers(UserAddVO addVO){
        Cusers cusers = new Cusers();
        cusers.setUserId(addVO.getUserId());
        cusers.setUserName(addVO.getUsername());
        cusers.setLoginName(addVO.getLoginName());
        int code = userMapper.insert(cusers);
        if(code==1){
            return CommonResult.success("添加成功");
        }
        else
            return CommonResult.fail("添加失败");
    }
}


