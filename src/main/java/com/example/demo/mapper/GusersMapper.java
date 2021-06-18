package com.example.demo.mapper;

import com.example.demo.entity.Gusers;
import com.example.demo.vos.user.UserQueryVO;

import java.util.List;

public interface GusersMapper {
    /**
     * 根据用户编号删除用户
     * @param userId 用户编号
     * @return 1 表示删除成功； 0 表示删除失败
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 添加信息完整的用户
     * @param record 完整的用户数据
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insert(Gusers record);

    /**
     * 添加信息不完整的用户
     * @param record 不完整的用户资料
     * @return 1 表示添加成功； 0 表示添加失败
     */
    int insertSelective(Gusers record);

    /**
     * 根据用户编号查询某个用户信息
     * @param userId 用户编号
     * @return 用户信息
     */
    Gusers selectByPrimaryKey(Integer userId);

    /**
     * 分页查询用户
     * @param query 查询条件
     * @return 某页的用户数据
     */
    List<Gusers> listOfUser(UserQueryVO query);

    /**
     * 更新用户信息
     * @param record 新的用户数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKeySelective(Gusers record);

    /**
     * 更新用户的全部信息
     * @param record 新的用户数据
     * @return 1 表示更新成功； 0 表示更新失败
     */
    int updateByPrimaryKey(Gusers record);
}