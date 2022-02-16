<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
    <style><%@include file="/WEB-INF/css/form.css"%></style>

</head>

<body>
<form name="form" class="form" action = "home?command=log_in"  method="post">
<%-- <%=    java code here , возвращает значение в виде Строки(заметь: там с = в начале)%>,<% java code(а тут без =), просто описывает логику, и не будет вставляться в HTML-e,в отлич. от первого%>  --%>

    <h1 class="form_title">Login</h1>

    <div class = "form_group">
        <input class = "form_input" name="username" id="username" placeholder="">
        <label class="form_label">User Name</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" name="password" type = "password" id = "password">
        <label class="form_label">password</label>
        <br>
        <label id="passwordText">Show password</label>

        <input type ="checkbox" id = "togglePassword">
        <script type="text/javascript">
            <%@include file="/WEB-INF/js/loginShowPass.js"%>
        </script>

        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>

        <br><br>
        <button type="submit" class="form_button">LOGIN</button>
    </div>
</form>
</body>
</html>
