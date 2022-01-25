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
    <% //In case, if Admin session is not set, redirect to Login page
        if((request.getSession(false).getAttribute("admin")== null) )
        {
    %>
    <jsp:forward page="loginPage.jsp"> </jsp:forward>
    <%} %>
</head>
<body>
<h2>Admin's Home</h2>

Welcome <%=request.getAttribute("login") %>

<div style="text-align: right"><a href="<%=request.getContextPath()%> /LogoutServlet">Logout</a></div>
</body>
</html>
