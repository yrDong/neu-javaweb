package com.yrd.web.servlet;

import com.alibaba.fastjson.JSON;
import com.yrd.pojo.Application;
import com.yrd.pojo.PageBean;
import com.yrd.service.ApplicationService;
import com.yrd.service.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/application/*")
public class ApplicationServlet extends BaseServlet{

    private ApplicationService applicationService = new ApplicationServiceImpl();

    public void addApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受申请信息
        //1.接收数据,request.getparameter不能接收json
        /* String brandName = request.getParameter("brandName");*/

        //获取请求体数据 application
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将json字符串转换
        Application application = JSON.parseObject(params, Application.class);

        System.out.println(params);

        //2.调用service 添加
        Application flag = applicationService.addApplication(application);
        System.out.println(flag);

        //3.response写数据
        response.setContentType("text/json;charset=utf-8");
        if (flag == null) {
            response.getWriter().write("success");
        } else response.getWriter().write("false");
    }

    public void selectApplicationIng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
       Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.selectApplicationIng(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void selectApplicationEd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.selectApplicationEd(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void lecSelectApplicationIng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.lecSelectApplicationIng(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void masSelectApplicationIng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.masSelectApplicationIng(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }


    public void lecSelectApplicationEd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.lecSelectApplicationEd(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void masSelectApplicationEd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String stuName = request.getParameter("userName");

        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.masSelectApplicationEd(currentPage, pageSize,stuName,application);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        //接受session数据，获取用户名
        HttpSession session = request.getSession();
        response.getWriter().write(jsonString);
    }

    public void agreeApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受申请信息
        //1.接收数据,request.getparameter不能接收json
        /* String brandName = request.getParameter("brandName");*/

        //获取请求体数据 application
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将json字符串转换
        Application application = JSON.parseObject(params, Application.class);


        //2.调用service 添加
        applicationService.agreeApplication(application);

        //3.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void rejectApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求体数据 application
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将json字符串转换
        Application application = JSON.parseObject(params, Application.class);


        //2.调用service
        applicationService.rejectApplication(application);

        //3.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void managerSelectAllApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5&username
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        //HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为brand
        Application application = JSON.parseObject(params, Application.class);

        //2调用service封装对象
        PageBean<Application> pageBean = applicationService.managerSelectAllApplication(currentPage, pageSize,application);

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
        applicationService.deleteByIds(ids);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void modifyApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        Application application= JSON.parseObject(params, Application.class);

        //2.调用service 添加记录
        applicationService.modifyApplication(application);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

}
