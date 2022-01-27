<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h2>Admin's Home</h2>

Welcome <%=request.getSession().getAttribute("admin") %>
<form action="/logout", method="get" >
<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
</form>
</body>
</html>
