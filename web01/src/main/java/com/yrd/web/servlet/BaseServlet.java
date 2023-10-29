package com.yrd.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*
* 替换HttpServlet,根据请求的最后一段进行方法分发
* */
public class BaseServlet extends HttpServlet {

    //根据请求的最后一段路劲来进行方法分发
    protected  void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        //1.获取请求路劲
        String uri = req.getRequestURI();  //  /web01/brand/selectAll
      //  System.out.println(uri);
        //2.获取最后一段路劲，方法名
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index+1);  //   /selectAll,+1去掉“/”
      //  System.out.println(methodName);

        //2.执行方法
        //2.1获取BrandServlet /UserServlet 字节码对象 class
        //谁调用this所在方法，this 代表谁
      //  System.out.println(this);   //  BrandServlet?HttpServlet  BrandServlet!
        Class<? extends BaseServlet > cls = this.getClass();

        //2.2获取method 对象
        try {
            Method method = cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //2.3执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
