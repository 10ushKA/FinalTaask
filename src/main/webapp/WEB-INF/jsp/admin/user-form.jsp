<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.02.2022
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>User Management Sign In Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>

    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #948a7d">
        <div>
            <a href="" class="navbar-brand"> User Management Page </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listOfUsers" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                            Edit User
                            </c:if>
<c:if test="${user == null}">
    Add New User
</c:if>
                        </h2>
                    </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>User login</label> <input type="text" value="<c:out value='${user.login}' />" class="form-control" name="login" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User password</label> <input type="text" value="<c:out value='${user.password}' />" class="form-control" name="password">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User role</label> <input type="text" value="<c:out value='${user.role}' />" class="form-control" name="role">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
