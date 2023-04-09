package com.peterjxl.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强，例如判断是否登陆
        System.out.println("filterDemo2执行了....");

        //放行
        chain.doFilter(request, response);

        //对response对象的响应消息增强，例如判断登陆成功，在响应消息中设置登录信息
        System.out.println("filterDemo2回来了...");
    }
}
