/**
 * Cookie案例，记住上次访问时间
 */
package com.peterjxl.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo6")
public class CookieDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        boolean flag = false;   //是否有lastTime的Cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String str_date = sdf.format(date);

        Cookie[] cs = req.getCookies();
        // 遍历Cookie
        if (cs != null) {
            for (Cookie c : cs) {
                if (c.getName().equals("lastTime")) {
                    flag = true;
                    resp.getWriter().write("欢迎回来，您上次访问时间为: " + c.getValue());
                    c.setValue(str_date);
                    c.setMaxAge(60 * 60 * 24 * 30);  //存储一个月
                    resp.addCookie(c);
                    break;
                }
            }
        }

        // 第一次访问
        if (!flag) {
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cookie);
            resp.getWriter().write("您好，欢迎您首次访问 " );

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
