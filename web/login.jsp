<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
        <script>
            window.onload = function (){
                var img = document.getElementById("checkCode");
                img.onclick = function (){
                    img.src = "/hello/checkCodeServlet2?date" + new Date().getTime();
                }
            }
        </script>
    </head>
    <body>
        <form action="/hello/loginServlet2" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="username"></td>
                </tr>

                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>验证码</td>
                    <td><input type="text" name="checkCode"></td>
                </tr>

                <tr>
                    <td colspan="2"><img id="checkCode" src="/hello/checkCodeServlet2"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="登录"></td>
                </tr>
            </table>
        </form>


        <div> <%= request.getAttribute("error_msg") == null ? "" : request.getAttribute("error_msg")%></div>
    </body>
</html>
