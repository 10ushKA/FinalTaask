<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All Users</title>
</head>
<body>
<h1>All Users</h1>
<table>
    <thead>
        <tr>
            <th>User Id</th>
            <th>User Login</th>
            <th>User Role</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>${user.status}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
