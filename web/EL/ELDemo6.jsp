<!--演示EL表达式 隐式对象 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL表达式 隐式对象</title>
    </head>
    <body>
        ${pageContext.request} <br>
        ${pageContext.request.contextPath} 在JSP页面动态获取虚拟目录 <br>
    </body>
</html>
