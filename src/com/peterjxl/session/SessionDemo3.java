package com.peterjxl.session;

/**
 * 通过设置Session的ID，保证浏览器关闭了会话也能保持
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session);
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60 * 60);
        resp.addCookie(c);
    }
}
