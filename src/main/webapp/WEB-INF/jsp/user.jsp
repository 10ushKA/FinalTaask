<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <% //In case, if User session is not set, redirect to Login page
        if((request.getSession(false).getAttribute("User")== null) )
        {
    %>
    <jsps:forward page="WEB-INF/jsp/loginPage.jsp"></jsps:forward>
    <%} %>
</head>
<body>
Welcome <%=request.getAttribute("login") %>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</body>
</html>
