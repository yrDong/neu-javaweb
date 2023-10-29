package com.yrd.web.servlet;

import com.alibaba.fastjson.JSON;
import com.yrd.pojo.Brand;
import com.yrd.pojo.Course;

import com.yrd.pojo.PageBean;
import com.yrd.pojo.User;
import com.yrd.service.CourseService;
import com.yrd.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/course/*")
public class CourseServlet extends BaseServlet{

    private CourseService courseService = new CourseServiceImpl();

    public void selectAllCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Course> courses = courseService.selectAllCourse();

        //2.调用json
        String jsonString = JSON.toJSONString(courses);
        System.out.println(courses);

        //3.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectCourseByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数 当前页码 和 每页显示条数   url?currentPage=16&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2调用service封装对象
        PageBean<Course> pageBean = courseService.selectCourseByPage(currentPage, pageSize);

        //3.调用json
        String jsonString = JSON.toJSONString(pageBean);

        //4.response写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 条件分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectCourseByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        //将json字符串转为course
        Course course = JSON.parseObject(params, Course.class);

        //2调用service封装对象
        PageBean<Course> pageBean = courseService.selectCourseByPageAndCondition(currentPage, pageSize,course);

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
        courseService.deleteByIds(ids);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据 [1,2,3]
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        Course course = JSON.parseObject(params, Course.class);

        //2.调用service 添加用户
        courseService.addCourse(course);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void modifyCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体数据 [1,2,3]
        BufferedReader br=request.getReader();
        String params = br.readLine();

        //将json字符串转为User
        Course course = JSON.parseObject(params, Course.class);

        //2.调用service 添加用户
        courseService.modifyCourse(course);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }
}
