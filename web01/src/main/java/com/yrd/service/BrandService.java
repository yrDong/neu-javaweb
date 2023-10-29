package com.yrd.service;

import com.yrd.pojo.Brand;
import com.yrd.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {

    /**
     *
     * 查询所有
    * */
    List<Brand> selectAll();

    /**
     *
     * 添加数据
    * */
    void add(Brand brand);

    /**
     * 根据id批量删除
     * */
    void deleteByIds( int[] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize     每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 条件分页查询
     * @param currentPage  当前页码
     * @param pageSize     每页展示条数
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);

    public void update(Brand brand);
}
