<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
    <h1>Update Client</h1>
<form method="post" action="admin?command=update-client">
    <div>Username for update:
    <input type="text" name="username" id="username">
    </div>
    <div>Password
    <input type="password" name="password" id="password">
    </div>
    <div>Role(user or admin)
    <input type="text" name="role" id="role">
    </div>
    <div>FirstName
        <input type="text" name="first_name" id="first_name">
    </div>
    <div>LastName
        <input type="text" name="last_name" id="last_name">
    </div>
    <div>Weight
        <input type="number" name="weight" id="weight">
    </div>
    <div>Height
        <input type="number" name="height" id="height">
    </div>
    <div>Age
        <input type="number" name="age" id="age">
    </div>
    <input type="submit">
</form>
</body>
</html>
