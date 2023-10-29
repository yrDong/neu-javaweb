package com.yrd.service;



import com.yrd.pojo.Brand;
import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    /**
     *
     * 查询所有课程
     * */
    List<Course> selectAllCourse();

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Course> selectCourseByPage(int currentPage,int pageSize);

    /**
     * 条件分页查询
     * @param currentPage
     * @param pageSize
     * @param course
     * @return
     */
    PageBean<Course> selectCourseByPageAndCondition(int currentPage, int pageSize, Course course);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 添加课程
     * */
    void addCourse(Course course);

    /**
     * 修改课程
     * */
    void modifyCourse(Course course);
}
