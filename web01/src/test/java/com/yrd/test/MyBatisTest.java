package com.yrd.test;

import com.yrd.mapper.BrandMapper;
import com.yrd.mapper.UserMapper;
import com.yrd.pojo.Brand;
import com.yrd.pojo.User;
import com.yrd.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll()throws IOException{
        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands =brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelecById()throws IOException{
        //接受参数
        int id =1;


        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand =brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelecByCondition()throws IOException{
        //接受参数
        int status =1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName ="%"+ companyName +"%";
        brandName ="%"+ brandName +"%";

        //封装对象
        /*Brand brand= new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        //Map
        Map map =new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);


        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        /*List<Brand> brands =brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands =brandMapper.selectByCondition(brand);*/

        List<Brand> brands =brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelecByConditionSingle()throws IOException{
        //接受参数
        int status =1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName ="%"+ companyName +"%";
        brandName ="%"+ brandName +"%";

        //封装对象
        Brand brand= new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        /*List<Brand> brands =brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands =brandMapper.selectByCondition(brand);*/

        List<Brand> brands =brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void testAdd()throws IOException{
        //接受参数
        int status =1;
        String companyName="波导手机";
        String brandName="波导";
        String description="手机中的战斗机";
        int ordered =100;


        //封装对象
        Brand brand= new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
       /* List<Brand> brands =brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands =brandMapper.selectByCondition(brand);
        List<Brand> brands =brandMapper.selectByConditionSingle(brand);*/
        brandMapper.add(brand);
        int id2= brand.getId();
        System.out.println(id2);


        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testupdata()throws IOException{
        //接受参数
        int status =0;
        String companyName="波导手机";
        String brandName="波导";
        String description="波导手机，手机中的战斗机";
        int ordered =100;
        int id=7;

        //封装对象
        Brand brand= new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        brand.setId(id);

        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        sqlSession.commit();


        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void testdeleteById()throws IOException{
        //接受参数

        int id=7;


        //1.加载mybatis核心配置文件，获取sqlsession
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);


        sqlSession.commit();


        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testdeleteByIds()throws IOException{
        //接受参数

        int[] ids={6,8,9};

        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        //3.获取BrandMapper接口的代理对象

        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);


        sqlSession.commit();


        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testzhujie()throws IOException{
        //接受参数

        int id=1;

        //1.加载mybatis核心配置文件，获取sqlsession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用它执行sql

        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取BrandMapper接口的代理对象

        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

        //4.执行方法
        //User user = userMapper.selectById(id);
        //System.out.println(user);

        //5.释放资源
        sqlSession.close();
    }
}
