package com.yrd.service;


import com.yrd.mapper.CourseMapper;
import com.yrd.mapper.UserMapper;
import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {

    //1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User select(String username, String password) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
       UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       //查询用户
        User user = mapper.select(username, password);

        return user;
    }

    @Override
    public PageBean<User> selectAllUser(int currentPage, int pageSize, User user) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理User条件。模糊表达式
        String name = user.getName();
        if(name != null && name.length()>0){
           user.setName("%"+name+"%");
        }

        String username = user.getUsername();
        if(username != null && username.length()>0){
           user.setUsername("%"+username+"%");
        }


        //查询当页数据
        List<User> rows = mapper.selectAllUser(begin,size,user);

        //查询总记录数
        int totalCount = mapper.selectUserCount(user);

        //封装pageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return pageBean;
    }

    public void addUser(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //添加用户
         mapper.addUser(user);

         //提交事务，关闭资源
         sqlSession.commit();
         sqlSession.close();

    }

    public void deleteByIds(int[] ids){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //删除用户
        mapper.deleteByIds(ids);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }

    public void modifyUser(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //添加用户
        mapper.modifyUser(user);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }
}
