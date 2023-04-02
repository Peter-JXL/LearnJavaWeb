package com.peterjxl.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 写法一 、 @WebServlet(urlPatterns = {"/demo3"})
// 写法二 、 @WebServlet(urlPatterns = "/demo3")
// 写法三 、 @WebServlet("/demo3")

@WebServlet("/demo3")
public class ServletDemo3Anno implements Servlet {

    //初始化方法  在Servlet被创建时，执行。只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("demo3 init.....");
    }

    //获取ServletConfig对象   ServletConfig：Servlet的配置对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法  每一次Servlet被访问时执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet Annotation!");
    }

    //获取Servlet的一些信息，版本，作者等等。
    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁方法   在服务器正常关闭时，执行，执行一次。
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
