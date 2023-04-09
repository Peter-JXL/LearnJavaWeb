package com.peterjxl.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 完成登录验证的过滤器
 */

//@WebFilter("/*")  //为了方便后续的学习，这里先注释了
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 0. 强转为HttpServlet，这样才能获取请求的资源路径
        HttpServletRequest req = (HttpServletRequest) request;
        // 1. 获取请求的资源路径
        String uri = req.getRequestURI();
        if (uri.contains("/login.jsp")
                || uri.contains("/loginServlet")
                || uri.contains("/css/")
                || uri.contains("/js/")
                || uri.contains("/fonts/")
                || uri.contains("/checkCodeServlet/")
        ){
            chain.doFilter(request, response);
        }else {
            // 不包含，需判断是否登录

            // 3. 从Session获取user
            Object user = req.getSession().getAttribute("user");
            if (null == user){
                System.out.println("已登录");
                chain.doFilter(request, response);
            }else {
                // 没有登录
                req.setAttribute("login_msg", "您尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
