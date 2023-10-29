package com.yrd.mapper;
import com.yrd.pojo.Brand;
import com.yrd.pojo.Course;
import com.yrd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    /**
     *
     * 查询所有
     */
    List<Course> selectAllCourse();

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */

    List<Course> selectCourseByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */

    List<Course> selectCourseByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("course") Course course);

    /**
     * 查询总记录数
     * @return
     */
    int selectCourseTotalCount();

    /**
     * 根据条件总记录数
     * @return
     */
    int selectCourseTotalCountByCondition(Course course);


    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 添加课程
     * */
    void addCourse(Course course);

    /**
     * 修改课程信息
     * */
    void modifyCourse(Course course);

}
