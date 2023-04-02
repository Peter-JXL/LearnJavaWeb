package com.peterjxl.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象获取请求头数据
 */

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {

    //演示获取请求头数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取某个请求头信息
        String agent = req.getHeader("user-agent");
        System.out.println("agent: " + agent);

        // 获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = req.getHeader(name); //根据名称获取请求头的值
            System.out.println(name + " : " + value);
        }
    }
}
