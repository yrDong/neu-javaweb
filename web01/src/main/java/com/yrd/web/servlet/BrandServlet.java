package com.yrd.web.servlet;


import com.alibaba.fastjson.JSON;
import com.yrd.pojo.Brand;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.service.BrandService;
import com.yrd.service.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();

        //2.调用json
        String jsonString = JSON.toJSONString(brands);

        //3.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据,request.getparameter不能接收json
        /* String brandName = request.getParameter("brandName");*/

        //获取请求体数据
        BufferedReader br =request.getReader();
        String params = br.readLine();

        //将json字符串转为对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        //2.调用service 添加
        brandService.add(brand);

        //3.响应成功标识
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据,request.getparameter不能接收json
        /* String brandName = request.getParameter("brandName");*/

        //获取请求体数据 [1,2,3]
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为int[]
        int [] ids = JSON.parseObject(params, int[].class);


        //2.调用service 添加
        brandService.deleteByIds(ids);

        //3.响应成功标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2调用service封装对象
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        System.out.println(user);


        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Brand brand = JSON.parseObject(params, Brand.class);

        //2调用service封装对象
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
