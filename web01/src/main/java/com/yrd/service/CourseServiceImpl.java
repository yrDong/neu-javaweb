package com.yrd.service;

import com.yrd.mapper.CourseMapper;

import com.yrd.mapper.UserMapper;
import com.yrd.pojo.Course;

import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    //1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Course> selectAllCourse() {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
       CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //4. 调用方法
        List<Course> courses = mapper.selectAllCourse();

        sqlSession.close();

        return courses;
    }

    @Override
    public PageBean<Course> selectCourseByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //查询当页数据
        List<Course> rows = mapper.selectCourseByPage(begin,size);

        //查询总记录数
        int totalCount = mapper.selectCourseTotalCount();

        //封装pageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Course> selectCourseByPageAndCondition(int currentPage, int pageSize, Course course) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理Course条件。模糊表达式
        String courseName = course.getName();
        if(courseName != null && courseName.length()>0){
            course.setName("%"+courseName+"%");
        }

        String lecturerName = course.getLecturerName();
        if(lecturerName != null && lecturerName.length()>0){
            course.setLecturerName("%"+lecturerName+"%");
        }

        String masterName = course.getMasterName();
        if(masterName != null && masterName.length()>0){
            course.setMasterName("%"+masterName+"%");
        }

        //查询当页数据
        List<Course> rows = mapper.selectCourseByPageAndCondition(begin,size,course);

        //查询总记录数
        int totalCount = mapper.selectCourseTotalCountByCondition(course);

        //封装pageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return pageBean;
    }

    public void deleteByIds(int[] ids){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //删除用户
        mapper.deleteByIds(ids);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }

    public void addCourse(Course course){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //添加用户
        mapper.addCourse(course);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }

    public void modifyCourse(Course course){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //添加用户
        mapper.modifyCourse(course);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }
}
