<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>PeterJXL</title>
    </head>
    <body>
      <% for(int i = 0; i < 10; i++){ %>
        <li> <%= i %> </li>
      <% } %>

      <%
        boolean flag = false;   //是否有lastTime的Cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String str_date = sdf.format(date);

        Cookie[] cs = request.getCookies();
        // 遍历Cookie
        if (cs != null) {
          for (Cookie c : cs) {
            if (c.getName().equals("lastTime")) {
              flag = true;
       %>

      <h1>欢迎回来，您上次访问的时间为 <%=c.getValue()%></h1>

      <%
              c.setValue(str_date);
              c.setMaxAge(60 * 60 * 24 * 30);  //存储一个月
              response.addCookie(c);
              break;
            }
          }
        }
        // 第一次访问
        if (!flag) {
          Cookie cookie = new Cookie("lastTime", str_date);
          cookie.setMaxAge(60 * 60 * 24 * 30);
          response.addCookie(cookie);
          out.write("您好，欢迎您首次访问 " );
        }
      %>
    </body>
</html>
