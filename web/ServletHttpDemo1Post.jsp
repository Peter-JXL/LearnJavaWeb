<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试post请求</title>
    </head>
    <body>
        <form action="/hello/httpDemo1" method="get">
            <span>用户名：</span><input type="text" name="username" placeholder="请输入用户名">
            <input type="submit" value="点击发送post请求">
        </form>
    </body>
</html>
