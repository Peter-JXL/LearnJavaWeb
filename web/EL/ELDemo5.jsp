<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!--演示EL表达式 空运算符 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            String str = "";
            request.setAttribute("str",str);
            List list = new ArrayList<>();
            request.setAttribute("list",list);
        %>

        empty str: ${empty str} <br>
        not empty str: ${not empty str} <br>
        empty list: ${empty list} <br>
        not empty list: ${not empty list} <br>
    </body>
</html>
