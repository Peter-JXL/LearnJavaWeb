package com.peterjxl.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 演示获取MIME

        // 2. 通过HttpServlet获取servletContext
        ServletContext servletContext = this.getServletContext();

        // 3. 定义文件名称
        String filename = "a.jpg";

        // 4. 获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println("mimeType: " + mimeType);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
