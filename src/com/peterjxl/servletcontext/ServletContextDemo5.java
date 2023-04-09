package com.peterjxl.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 演示获取文件真实路径

        // 2. 通过HttpServlet获取servletContext
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/b.txt");
        System.out.println(realPath);
        File file = new File(realPath);

        String realPath2 = servletContext.getRealPath("/WEB-INF/b.txt");
        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println("realPath2: " + realPath2);
        System.out.println("realPath3: " + realPath3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
