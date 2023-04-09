package com.peterjxl.login2;

import com.peterjxl.dao.UserDao;
import com.peterjxl.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet2")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 判断验证码是否正确
        HttpSession session = req.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if( checkCodeSession != null && checkCodeSession.equalsIgnoreCase(checkCode)){   //忽略大小写来比较字符串
            //3.封装user对象
            User loginUser = new User();
            loginUser.setName(name);
            loginUser.setPassword(password);

            //4.调用UserDao的login方法
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);

            //5.判断user
            if(user == null){
                //登录失败
                req.setAttribute("error_msg", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }else{
                //登录成功
                //存储数据
                session.setAttribute("user",user);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            }
        }else{  // 验证码不一致
            req.setAttribute("error_msg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
