package com.example.demo.mapper;

import com.example.demo.entity.Cusers;
import com.example.demo.vos.user.UserQueryVO;

import java.util.List;

public interface CusersMapper {

    /**
     * 添加用户
     * @param record 完整的用户数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Cusers record);


    /**
     * 根据用户编号查询某个用户信息
     * @param userId 用户编号
     * @return 用户信息
     */
    Cusers selectByPrimaryKey(Integer userId);


    /**
     * 根据登录名查询用户
     * @param loginName
     * @return
     */
    Cusers selectByUsername(String loginName);

    /**
     * 分页查询用户
     * @param query 查询条件
     * @return 某页的用户数据
     */
    List<Cusers> listOfUser(UserQueryVO query);


    /**
     * 获取全部用户数据
     * @return
     */
    List<Cusers> listUserInfo();

    /**
     * 查询指定条件的用户总数
     * @param query
     * @return
     */
    int selectUserAmount(UserQueryVO query);

    /**
     * 更新用户信息
     * @param record 新的用户数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Cusers record);

}