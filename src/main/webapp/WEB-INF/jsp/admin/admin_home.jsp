<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Admin Home</title>
    <style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<div class="centered">
    <a href="admin?command=to-all-clients"><button class="form_button">Show Clients</button></a>
    <br><br>
    <a href="admin?command=to-create-client"><button class="form_button">Create Client</button></a>
    <br><br>
    <a href="admin?command=to-update-client"><button class="form_button">Update Client</button></a>
    <br><br>
    <a href="admin?command=to-delete-client"><button class="form_button">Delete Client</button></a>
    <br><br><br>
    <a href="/home?command=to_login"><button class="form_button">LOGOUT</button></a>
</div>
</body>
</html>
