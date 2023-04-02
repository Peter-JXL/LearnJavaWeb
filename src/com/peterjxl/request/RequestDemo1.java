package com.peterjxl.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();    //1. 获取请求方式：get
        String contextPath = req.getContextPath();  //2。获取虚拟目录，/hello
        String servletPath = req.getServletPath();  //3.获取Servlet路径，/requestDemo1
        String queryString = req.getQueryString();  //4.获取get方式请求参数
        String requestURI  = req.getRequestURI();   //5.获取请求URI：/hello/requestDemo1
        StringBuffer requestURL = req.getRequestURL();  //5. 获取请求URL：
        String protocol = req.getProtocol();    //6.获取协议版本 HTTP/1.1
        String remoteAddr = req.getRemoteAddr();    //7.获取客户的IP地址

        System.out.println("method: " + method);
        System.out.println("contextPath: " + contextPath);
        System.out.println("servletPath: " + servletPath);
        System.out.println("queryString: " + queryString);
        System.out.println("requestURI: " + requestURI);
        System.out.println("requestURL: " + requestURL);
        System.out.println("protocol: " + protocol);
        System.out.println("remoteAddr: " + remoteAddr);
    }
}
