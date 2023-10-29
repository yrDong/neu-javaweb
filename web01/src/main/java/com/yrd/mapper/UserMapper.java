package com.yrd.mapper;

import com.yrd.pojo.Course;
import com.yrd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 分页条件查询
     * 用户数据
     * @param begin
     * @param size
     * @return
     */

    List<User> selectAllUser(@Param("begin") int begin, @Param("size") int size, @Param("user") User user);

    /**
     * 根据条件总记录数
     * 用户个数
     * @return
     */
    int selectUserCount(User user);

    /**
    * 根据用户名查询用户
    * */
    User selectByUsername(String username);


    /**
    * 查询单个用户
    * */
    User select(@Param("username") String username, @Param("password") String password);

    /**
    * 添加用户
    * */
    void addUser(User user);

    /**
     * 修改用户
     * */
    void modifyUser(User user);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);
}
