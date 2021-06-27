package com.example.demo.service;

import antlr.StringUtils;
import com.example.demo.common.CommonResult;
import com.example.demo.common.entityEnum.RecordExistEnum;
import com.example.demo.dtos.UserListDTO;
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
        int amount = userMapper.selectUserAmount(queryVO);
        UserListDTO listDTO = new UserListDTO();
        listDTO.setList(cusersList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
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
        if (fixVO.getUserId() == null) {
            return CommonResult.fail("修改失败");
        }
        Cusers cusers = new Cusers();
        cusers.setUserId(fixVO.getUserId());
        if (fixVO.getLoginName() != null && !"".equals(fixVO.getLoginName())) {
            cusers.setLoginName(fixVO.getLoginName());
        }
        if (fixVO.getUserName() != null && !"".equals(fixVO.getUserName())) {
            cusers.setUserName(fixVO.getUserName());
        }
        if (fixVO.getStatus() != null) {
            cusers.setStatus(fixVO.getStatus());
        }
        int code = userMapper.updateByPrimaryKeySelective(cusers);
        if(code==1){
            return  CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    public CommonResult<Object> addUsers(UserAddVO addVO){
        if (addVO.getEmpId() == null ||
            addVO.getLoginName() == null ||
            addVO.getUserName() == null ||
                addVO.getStatus() == null
        ) {
            return CommonResult.fail("添加失败，请不要输入空数据");
        }
        Cusers cusers = new Cusers();
        cusers.setEmployeeId(addVO.getEmpId());
        cusers.setUserName(addVO.getUserName());
        cusers.setLoginName(addVO.getLoginName());
        cusers.setStatus(addVO.getStatus());
        cusers.setUserStatus(RecordExistEnum.exist.getCode());
        cusers.setUserPwd("".equals(addVO.getUserPwd()) ? "123456" : addVO.getUserPwd());
        int code = userMapper.insert(cusers);
        if(code == 1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
}


