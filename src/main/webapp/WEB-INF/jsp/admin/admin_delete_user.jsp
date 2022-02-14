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
</head>
<body>
<h1>Delete User</h1>
    <form method="post" action="admin?command=delete-client">
        <input type="text" id="username" name="username">
        <input type="submit">
    </form>
</body>
</html>
