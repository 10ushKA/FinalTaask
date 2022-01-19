<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="src/main/webapp/WEB-INF/css/login.css">
    <style><%@include file="/WEB-INF/css/login.css"%></style>

</head>

<body>
<form name="form" class="form" action="<%=request.getContextPath()%>/LoginServletRoled" method="post">
<%--<%=java code, возвращает значение в виде Строки(заметь: там с = в начале)%>,<%java code(а тут без), просто описывает логику, и не будет вставляться в HTML-e,в отлич. от первого%>  --%>

    <h1 class="form_title">Login</h1>

    <div calss = "form_group">
        <input class = "form_input" placeholder="">
        <label class="form_label">login</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" type = "password" id = "password">
        <label class="form_label">password</label>
        <br>
        <label id="passwordText">Show password</label>

        <input type ="checkbox" id = "togglePassword">
        <script type="text/javascript">
            <%@include file="/WEB-INF/js/login.js"%>
        </script>

        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>

        <br><br>
        <button class="form_button">LOGIN</button>
    <%--<table align="center">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"></input><input type="reset" value="Reset"></input></td>
        </tr>
    </table>--%>
</form>
</body>
</html>
