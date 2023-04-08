<!--演示EL表达式获取值 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            //在域中存储数据
            session.setAttribute("name","李四");
            request.setAttribute("name","张三");
            session.setAttribute("age","23");
            request.setAttribute("str","");
        %>

        <h3>el获取值</h3>
        ${requestScope.name}
        ${sessionScope.age}
        ${sessionScope.haha}    <!-- 没有这个属性，不会显示在页面上 -->

        ${name}  从小到大依次寻找，所以找到的是request的，输出张三。
        ${sessionScope.name}
    </body>
</html>
