package com.peterjxl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>(); //敏感词汇集合
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强getParameter方法
                System.out.println("执行过滤了");
                if (method.getName().equals("getParameter")){
                    System.out.println("method.getName().equals(\"getParameter\")");
                    String value = (String) method.invoke(servletRequest, args);
                    if( null != value){
                        for(String str : list){
                            if(value.contains(str)){
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }

                    return value;   //返回过滤后的字符
                }
                return method.invoke(servletRequest, args);
            }
        });
        filterChain.doFilter(proxy_req, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            // 1. 加载文件
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            BufferedReader bufferedReader = null;

            // 2. 读取文件
            bufferedReader = new BufferedReader(new FileReader(realPath));

            // 3. 将文件的每一行放到list
            String line = null;
            while( (line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            System.out.println("敏感词汇list: " + list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
