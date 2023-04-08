<%@ page import="com.peterjxl.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!--演示EL表达式获取对象类型的值 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            User user = new User();
            user.setName("张三");
            request.setAttribute("u",user);


            List list = new ArrayList<String>();
            list.add("aaa");
            list.add("bbb");
            list.add(user);
            request.setAttribute("list",list);


            Map map = new HashMap();
            map.put("sname","李四");
            map.put("gender","男");
            map.put("user",user);
            request.setAttribute("map",map);

        %>

        <h3>el获取对象中的值</h3>
        ${requestScope.u}<br>  相当于System.out.println(u); 打印对象的地址
        ${requestScope.u.name}<br>
        ${u.name}<br>

        <h3>el获取List值</h3>
        ${list}<br>
        ${list[0]}<br>
        ${list[1]}<br>
        ${list[10]} 如果越界了，不会在页面上展示错误信息。<br>
        ${list[2].name}  User对象

        <h3>el获取Map值</h3>
        ${map.gender}<br>
        ${map["gender"]}<br>
        ${map.user.name}
    </body>
</html>
