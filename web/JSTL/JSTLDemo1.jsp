<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>if标签</title>
    </head>
    <body>
      <c:if test="true">
        <h1>我是真...</h1>
      </c:if>

      <%
        //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合
        List list = new ArrayList<>();
        list.add("aaaa");
        request.setAttribute("list",list);
        request.setAttribute("number",4);
      %>

      <c:if test="${not empty list}">
        遍历集合...
      </c:if>


      <c:if test="${number % 2 != 0}">  ${number}为奇数 </c:if>
      <c:if test="${number % 2 == 0}">  ${number}为偶数 </c:if>
    </body>
</html>
