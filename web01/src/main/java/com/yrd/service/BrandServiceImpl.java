package com.yrd.service;

import com.yrd.mapper.BrandMapper;
import com.yrd.pojo.Brand;
import com.yrd.pojo.PageBean;
import com.yrd.util.SqlSessionFactoryUtils;
import com.yrd.web.servlet.BrandServlet;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     *
     */
    @Override
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加数据
     * @param brand
     */
    @Override
    public void add(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



    /**
     * 根据id查询
     * @return
     */
    public Brand selectById(int id){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }


    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    /**
     * 根据id批量删除
     * */
    @Override
    public void deleteByIds(int[] ids){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //查询当页数据
        List<Brand> rows = mapper.selectByPage(begin,size);

        //查询总记录数
        int totalCount = mapper.selectTotalCount();

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();


        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理brand条件。模糊表达式
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }

        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }

        //查询当页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin,size,brand);

        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return pageBean;
    }
}

