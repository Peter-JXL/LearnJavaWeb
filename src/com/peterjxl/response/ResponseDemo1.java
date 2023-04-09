package com.peterjxl.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向演示
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问/responseDemo1，会自动跳转到/responseDemo2资源

        System.out.println("/responseDemo1....");
        // 1. 设置状态码
        resp.setStatus(302);
        // 2.设置响应头
        resp.setHeader("location", "/hello/responseDemo2");

        // 一步到位
        //response.sendRedirect("/hello/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
