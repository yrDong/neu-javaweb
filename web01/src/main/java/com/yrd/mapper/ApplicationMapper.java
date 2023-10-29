package com.yrd.mapper;

import com.yrd.pojo.Application;
import com.yrd.pojo.Course;
import com.yrd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
public interface ApplicationMapper {

    /**
     * 判断是否已选
     * @param application
     * @return
     */
    Application judge(Application application);


    /**
     * 添加申请
     * @param application
     */
    void addApplication(Application application);

    /**
     * 分页条件查询
     * 学生
     * 未完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> selectApplicationIng(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);


    /**
     * 学生
     * 根据条件查询总记录数
     * @param userName
     * @param application
     * @return
     */
    int selectTotalCountIng(@Param("userName") String userName,@Param("application") Application application);

    /**
     * 分页条件查询
     * 学生
     * 已完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> selectApplicationEd(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);

    /**
     * 根据条件查询总记录数
     * 学生
     * 已完成审批的记录
     * @param userName
     * @param application
     * @return
     */
    int selectTotalCountEd(@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主讲教师
     * 分页条件查询
     * 未完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> lecSelectApplicationIng(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主管教师
     * 分页条件查询
     * 未完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> masSelectApplicationIng(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);


    /**
     * 主讲教师
     * 根据条件查询总记录数
     * @param userName
     * @param application
     * @return
     */
    int lecSelectTotalCountIng(@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主管教师
     * 根据条件查询总记录数
     * @param userName
     * @param application
     * @return
     */
    int masSelectTotalCountIng(@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主讲教师
     * 分页条件查询
     * 已完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> lecSelectApplicationEd(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主管教师
     * 分页条件查询
     * 已完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    List<Application> masSelectApplicationEd(@Param("begin") int begin,@Param("size") int size,@Param("userName") String userName,@Param("application") Application application);


    /**
     * 主讲教师
     * 根据条件查询总记录数
     * @param userName
     * @param application
     * @return
     */
    int lecSelectTotalCountEd(@Param("userName") String userName,@Param("application") Application application);

    /**
     * 主管教师
     * 根据条件查询总记录数
     * @param userName
     * @param application
     * @return
     */
    int masSelectTotalCountEd(@Param("userName") String userName,@Param("application") Application application);


    /**
     * 通过申请
     * @param application
     */
    void agreeApplication(Application application);

    /**
     * 驳回申请
     * @param application
     */
    void rejectApplication(Application application);

    /**
     * 管理员
     * 分页条件查询
     * 所有记录
     * @param begin
     * @param size
     * @param application
     * @return
     */
    List<Application> managerSelectAllApplication(@Param("begin") int begin,@Param("size") int size,@Param("application") Application application);

    /**
     * 管理员
     * 根据条件查询总记录数
     * @param application
     * @return
     */
    int managerSelectAllApplicationCount(Application application);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 修改记录
     * */
    void modifyApplication(Application application);

}
