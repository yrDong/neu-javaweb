package com.yrd.service;

import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 查询单个用户
     * */
    User select( String username, String password);

    /**
     * 分页条件查询
     * 用户数据
     * @param begin
     * @param size
     * @param user
     * @return
     */
    PageBean<User> selectAllUser(int begin, int size, User user);

    /**
     * 添加用户
     * */
    void addUser(User user);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(int[] ids);

    /**
     * 修改用户
     * */
    void modifyUser(User user);
}
