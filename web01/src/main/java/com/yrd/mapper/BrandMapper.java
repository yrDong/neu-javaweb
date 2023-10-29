package com.yrd.mapper;

import com.yrd.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     *
     * 查询所有
     */
     List<Brand> selectAll();

    /**
    *
    * 查看详情：根据id查询
    */
    Brand selectById(int id);

    /**
     *
     * 条件查询
     *      1.散装查询：如果方法中有多个参数。需使用@param("SQl参数占位符名称)
     *      2.对象参数:对象的属性名称要与参数占位符名称一致
     *      3.map集合参数
     */
   /* List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);
    List<Brand> selectByCondition(Brand brand);*/
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    /**
    * 添加
    * */
    void add(Brand brand);

    /**
     * 修改
     * */
    int update(Brand brand);

    /**
     * 根据id删除
     * */
    void deleteById(int id);

    /**
     * 根据id批量删除
     * */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */

    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */

    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
