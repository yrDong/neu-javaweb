package com.yrd.service;

import com.yrd.mapper.ApplicationMapper;
import com.yrd.mapper.CourseMapper;
import com.yrd.pojo.Application;
import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService{

    //1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Application judge(Application application) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        Application application1 = mapper.judge(application);

        sqlSession.close();

        return application1;
    }

    @Override
    public Application addApplication(Application application) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        Application application1 = mapper.judge(application);
        if(application1 == null){
            mapper.addApplication(application);
            //提交事务
            sqlSession.commit();
            sqlSession.close();
            return null;
        }else {
            sqlSession.close();
            return application1;
        }

    }

    @Override
    public void modifyApplication(Application application) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        mapper.modifyApplication(application);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

     public PageBean<Application> selectApplicationIng(int currentPage, int pageSize, String userName,Application application){
         //2. 获取SqlSession
         SqlSession sqlSession = factory.openSession();
         //3. 获取ApplicationMapper
         ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

         //4. 调用方法
         //计算开始索引
         int begin = (currentPage-1) * pageSize;
         //计算查询条目数
         int size = pageSize;

         //处理条件。模糊表达式
         String courseName = application.getCourseName();
         if(courseName != null && courseName.length()>0){
             application.setCourseName("%"+courseName+"%");
         }

         String lecturerName = application.getLecturerName();
         if(lecturerName != null && lecturerName.length()>0){
             application.setLecturerName("%"+lecturerName+"%");
         }

         String masterName = application.getMasterName();
         if(masterName != null && masterName.length()>0){
             application.setMasterName("%"+masterName+"%");
         }

         //查询当页数据
         List<Application> rows = mapper.selectApplicationIng(begin,size,userName,application);

         //查询总记录数
         int totalCount = mapper.selectTotalCountIng(userName,application);

         //封装pageBean对象
         PageBean<Application> pageBean = new PageBean<>();
         pageBean.setRows(rows);
         pageBean.setTotalCount(totalCount);

         //释放资源
         sqlSession.close();
         return pageBean;

     }

    public PageBean<Application> selectApplicationEd(int currentPage, int pageSize, String userName,Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理Course条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String lecturerName = application.getLecturerName();
        if(lecturerName != null && lecturerName.length()>0){
            application.setLecturerName("%"+lecturerName+"%");
        }

        String masterName = application.getMasterName();
        if(masterName != null && masterName.length()>0){
            application.setMasterName("%"+masterName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.selectApplicationEd(begin,size,userName,application);

        //查询总记录数
        int totalCount = mapper.selectTotalCountEd(userName,application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;

    }

    public PageBean<Application> lecSelectApplicationIng(int currentPage, int pageSize, String userName,Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取ApplicationMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String stuName = application.getStuName();
        if(stuName != null && stuName.length()>0){
            application.setStuName("%"+stuName+"%");
        }

        String masterName = application.getMasterName();
        if(masterName != null && masterName.length()>0){
            application.setMasterName("%"+masterName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.lecSelectApplicationIng(begin,size,userName,application);

        //查询总记录数
        int totalCount = mapper.lecSelectTotalCountIng(userName,application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;

    }

    public PageBean<Application> masSelectApplicationIng(int currentPage, int pageSize, String userName,Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理Course条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String stuName = application.getStuName();
        if(stuName != null && stuName.length()>0){
            application.setStuName("%"+stuName+"%");
        }

        String lectureName = application.getLecturerName();
        if(lectureName != null && lectureName.length()>0){
            application.setLecturerName("%"+lectureName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.masSelectApplicationIng(begin,size,userName,application);

        //查询总记录数
        int totalCount = mapper.masSelectTotalCountIng(userName,application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;

    }

    public PageBean<Application> lecSelectApplicationEd(int currentPage, int pageSize, String userName,Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理Course条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String stuName = application.getStuName();
        if(stuName != null && stuName.length()>0){
            application.setStuName("%"+stuName+"%");
        }

        String masterName = application.getMasterName();
        if(masterName != null && masterName.length()>0){
            application.setMasterName("%"+masterName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.lecSelectApplicationEd(begin,size,userName,application);

        //查询总记录数
        int totalCount = mapper.lecSelectTotalCountEd(userName,application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;

    }

    public PageBean<Application> masSelectApplicationEd(int currentPage, int pageSize, String userName,Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理Course条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String stuName = application.getStuName();
        if(stuName != null && stuName.length()>0){
            application.setStuName("%"+stuName+"%");
        }

        String lectureName = application.getLecturerName();
        if(lectureName != null && lectureName.length()>0){
            application.setLecturerName("%"+lectureName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.masSelectApplicationEd(begin,size,userName,application);

        //查询总记录数
        int totalCount = mapper.masSelectTotalCountEd(userName,application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;

    }

    public void agreeApplication(Application application){
            //2. 获取SqlSession
            SqlSession sqlSession = factory.openSession();
            //3. 获取CourseMapper
            ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);
            //4. 调用方法
            mapper.agreeApplication(application);
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();

        }

    public void rejectApplication(Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);
        //4. 调用方法
        mapper.rejectApplication(application);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public PageBean<Application> managerSelectAllApplication(int currentPage, int pageSize, Application application){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取CourseMapper
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理筛选条件。模糊表达式
        String courseName = application.getCourseName();
        if(courseName != null && courseName.length()>0){
            application.setCourseName("%"+courseName+"%");
        }

        String stuName = application.getStuName();
        if(stuName != null && stuName.length()>0){
            application.setStuName("%"+stuName+"%");
        }

        String lectureName = application.getLecturerName();
        if(lectureName != null && lectureName.length()>0){
            application.setLecturerName("%"+lectureName+"%");
        }

        String masterName = application.getMasterName();
        if(masterName != null && masterName.length()>0){
            application.setMasterName("%"+masterName+"%");
        }

        //查询当页数据
        List<Application> rows = mapper.managerSelectAllApplication(begin,size,application);

        //查询总记录数
        int totalCount = mapper.managerSelectAllApplicationCount(application);

        //封装pageBean对象
        PageBean<Application> pageBean = new PageBean<>();
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
        ApplicationMapper mapper = sqlSession.getMapper(ApplicationMapper.class);

        //删除用户
        mapper.deleteByIds(ids);

        //提交事务，关闭资源
        sqlSession.commit();
        sqlSession.close();

    }
}
