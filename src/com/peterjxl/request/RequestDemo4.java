package com.peterjxl.request;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // 根据参数名称获取参数值
       String username = req.getParameter("username");
       System.out.println("username: " + username);

       // 根据参数名称获取参数值的数组
       String[] hobbies = req.getParameterValues("hobby");
       for (String hobby: hobbies) {
           System.out.println(hobby);
       }

       // 获取所有请求的参数名称
       Enumeration<String> parameterNames = req.getParameterNames();
       while(parameterNames.hasMoreElements()){
           String name = parameterNames.nextElement();
           String value = req.getParameter(name);
           System.out.printf("name: %s, value: %s\n", name, value);
       }
       
       // 获取所有参数的map集合
       Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset){
            System.out.print("name: " + name);
            // 根据键获取值
            String[] values = parameterMap.get(name);
            for (String value : values){
                System.out.print("  value: " + value);
            }
            System.out.println();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
