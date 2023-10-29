package com.yrd.web.servlet;


import com.alibaba.fastjson.JSON;
import com.yrd.pojo.Course;
import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.service.UserService;
import com.yrd.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    private UserService userService = new UserServiceImpl();


    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据 [1,2,3]
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        User user = JSON.parseObject(params, User.class);

        //2.调用service 添加用户
        userService.addUser(user);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据,request.getparameter不能接收json
        /* String brandName = request.getParameter("brandName");*/

        //获取请求体数据
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        User user = JSON.parseObject(params, User.class);

        //2.调用service 查询
        User user1 = userService.select(user.getUsername(), user.getpassword());

        String jsonString = JSON.toJSONString(user1);
        System.out.println(jsonString);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为user
        User user = JSON.parseObject(params, User.class);

        //2调用service封装对象
        PageBean<User> pageBean = userService.selectAllUser(currentPage, pageSize,user);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据 [1,2,3]
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        int[] ids = JSON.parseObject(params, int[].class);

        //2.调用service 添加用户
        userService.deleteByIds(ids);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void modifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        User user = JSON.parseObject(params, User.class);

        //2.调用service 添加用户
        userService.modifyUser(user);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }
}
