package com.yrd.service;

import com.yrd.pojo.Application;
import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationService {

    /**
     * 判断是否已选
     * @param application
     * @return
     */
    Application judge(Application application);


    /**
     * 学生
     * 分页条件查询
     * 未完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    PageBean<Application> selectApplicationIng(int begin, int size, String userName, Application application);

    /**
     * 学生
     * 分页条件查询
     * 已完成审批的记录
     * @param begin
     * @param size
     * @param userName
     * @param application
     * @return
     */
    PageBean<Application> selectApplicationEd(int begin, int size, String userName, Application application);

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
    PageBean<Application> lecSelectApplicationIng(int begin, int size, String userName, Application application);

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
    PageBean<Application> masSelectApplicationIng(int begin, int size, String userName, Application application);

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
    PageBean<Application> lecSelectApplicationEd(int begin, int size, String userName, Application application);

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
    PageBean<Application> masSelectApplicationEd(int begin, int size, String userName, Application application);

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
    PageBean<Application> managerSelectAllApplication (int begin,int size, Application application);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 添加申请
     * @param application
     * @return
     */
    Application addApplication(Application application);

    /**
     * 修改申请
     * @param application
     * @return
     */
    void modifyApplication(Application application);
}
