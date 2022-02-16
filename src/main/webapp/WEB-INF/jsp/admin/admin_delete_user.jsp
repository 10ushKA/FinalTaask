<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
    <style><%@include file="/WEB-INF/css/form.css"%></style>
    <style><%@include file="/WEB-INF/css/custom_buttons.css"%></style>
</head>
<body>
<a href="admin?command=to_admin_home" class="previous round" style="margin-right: 40px;">&#8249;</a>
    <form method="post" action="admin?command=delete-client">
        <input type="text" id="username" name="username" placeholder="User Name To Delete" style="border-radius: 5px;">
        <button type="submit" class="form_button">DELETE</button>
    </form>
</body>
</html>
