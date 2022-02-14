<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.02.2022
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #948a7d">
        <div>
            <a href="" class="navbar-brand"> User
                Management </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listOfUsers" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/admin/new" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
<table class="table table-bordered">
<thead>
<tr>
    <th>ID</th>
    <th>Login</th>
    <th>Password</th>
    <th>Role</th>
    <th>Actions</th>
</tr>
</thead>
<tbody>
<!--   for (Todo todo: todos) {  -->
<c:forEach var="userAccount" items="${listUser}">

    <tr>
    <td>
    <c:out value="${userAccount.id}" />
    </td>
    <td>
    <c:out value="${userAccount.login}" />
    </td>
    <td>
    <c:out value="${userAccount.password}" />
    </td>
    <td>
        <c:out value="${userAccount.role}" />
    </td>
        <td><a href="edit?id=<c:out value='${userAccount.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${userAccount.id}' />">Delete</a></td>
    </tr>
</c:forEach>
<!-- } -->
</tbody>

</table>
    </div>
</div>
</body>
</html>
