package com.example.demo.service;

//import antlr.StringUtils;
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

    /**
     * 分页查询用户
     * @param queryVO 查询条件
     * @return
     */
    public CommonResult<Object> getUsers(UserQueryVO queryVO){
        // 分页查询用户
        List<Cusers> cusersList = userMapper.listOfUser(queryVO);
        // 获取符合查询条件的用户数量
        int amount = userMapper.selectUserAmount(queryVO);
        // 将数据放到DTO
        UserListDTO listDTO = new UserListDTO();
        listDTO.setList(cusersList);
        listDTO.setTotal(amount);
        return CommonResult.success(listDTO);
    }

    /**
     * 删除用户
     * @param deleteVO 删除条件
     * @return
     */
    public  CommonResult<Object> deleteUser(UserDeleteVO deleteVO){
        List<Integer> ids = deleteVO.getIds();
        ids.forEach(id ->{
            Cusers cusers = new Cusers();
            // 设置被删除的用户编号
            cusers.setUserId(id);
            cusers.setUserStatus(0);
            // 调用用户DAO层的更新方法，设置user_status字段为0
            userMapper.updateByPrimaryKeySelective(cusers);
        });
        return CommonResult.success("删除成功");
    }

    /**
     * 更新用户
     * @param fixVO 用户新信息
     * @return
     */
    public  CommonResult<Object> updateUsers(UserFixVO fixVO){
        if (fixVO.getUserId() == null) {
            return CommonResult.fail("修改失败");
        }
        Cusers cusers = new Cusers();
        cusers.setUserId(fixVO.getUserId());
        // 设置要更新的用户信息，同时判断是有空，如果有空，就需要设置null，便于DAO的判断
        if (fixVO.getLoginName() != null && !"".equals(fixVO.getLoginName())) {
            cusers.setLoginName(fixVO.getLoginName());
        }
        if (fixVO.getUserName() != null && !"".equals(fixVO.getUserName())) {
            cusers.setUserName(fixVO.getUserName());
        }
        if (fixVO.getStatus() != null) {
            cusers.setStatus(fixVO.getStatus());
        }
        // 调用DAO层的更新方法，并判断返回值
        int code = userMapper.updateByPrimaryKeySelective(cusers);
        if(code==1){
            return  CommonResult.success("更新成功");
        }
        return CommonResult.fail("更新失败");
    }

    /**
     * 添加用户
     * @param addVO 新用户数据
     * @return
     */
    public CommonResult<Object> addUser(UserAddVO addVO){
        // 需要判断是否有空数据
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
        // 如果密码为空，则设置默认密码
        cusers.setUserPwd("".equals(addVO.getUserPwd()) ? "123456" : addVO.getUserPwd());
        // 调用用户DAO层的添加方法，并判断返回值
        int code = userMapper.insert(cusers);
        if(code == 1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.fail("添加失败");
    }
}


