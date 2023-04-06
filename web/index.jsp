<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <h1>Hello JSP!</h1>
    <% System.out.println("Hello"); %>

    <%! int i = 1; %>

    <%= "hello".toUpperCase() %>

    <% out.print("hell out"); %>

    <% response.getWriter().write("hello, response"); %>
  </body>
</html>
