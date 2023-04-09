package com.peterjxl.login;

import com.peterjxl.dao.UserDao;
import com.peterjxl.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
//        //2.获取请求参数
//        String name = req.getParameter("name");
//        String password = req.getParameter("password");
//        //3.封装user对象
//        User loginUser = new User();
//        loginUser.setName(name);
//        loginUser.setPassword(password);

        // 2.通过BeanUtils来获取所有参数并封装
        Map<String, String[]> parameterMap =req.getParameterMap();
        //3.创建user对象
        User loginUser = new User();
        //3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println(loginUser);

        //4.调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //5.判断user
        if(user == null){
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登录成功
            //存储数据
            req.setAttribute("user",user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
