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
    <title>All Clients</title>
    <style><%@include file="/WEB-INF/css/table.css"%></style>
    <style><%@include file="/WEB-INF/css/custom_buttons.css"%></style>
</head>
<body>
<a href="admin?command=to_admin_home" class="previous round">&#8249;</a>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <!--   for (Todo todo: todos) {  -->
    <c:forEach var="user" items="${users}">

        <tr>
            <td>
                <c:out value="${user.id}" />
            </td>
            <td>
                <c:out value="${user.username}" />
            </td>
            <td>
                <c:out value="${user.status}" />
            </td>
        </tr>
    </c:forEach>
    <!-- } -->
    </tbody>

</table>
</body>
</html>
