<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>User Page</title>
    <% //In case, if User session is not set, redirect to Login page
        if((request.getSession(false).getAttribute("user")== null) )
        {
    %>
    <jsp:forward page="loginPage.jsp"> </jsp:forward>
    <%} %>
</head>

<body>
    <h2>User's HomePage</h2>
Welcome <%=request.getAttribute("login") %><%--потом перепиши чтобы переводило Юзера на ХоумПэйдж, а Админа(в админ.джсп) на какую-то др.--%>
<div style="text-align: right"><a href="<%=request.getContextPath()%> /LogoutServlet">Logout</a></div>

</body>
</html>
