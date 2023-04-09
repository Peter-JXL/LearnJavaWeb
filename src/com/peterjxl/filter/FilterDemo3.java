package com.peterjxl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 演示生命周期
 */
@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo3 Init....");
    }

    public void destroy() {
        System.out.println("FilterDemo3 destroy....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
