<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录后页面</title>
    </head>
    <body>
      <h1><%= request.getSession().getAttribute("user")%>，欢迎您 </h1>
    </body>
</html>
