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
</head>

<body>
    <h2>User's HomePage</h2>
Welcome <%=request.getSession().getAttribute("user") %><%--потом перепиши чтобы переводило Юзера на ХоумПэйдж, а Админа(в админ.джсп) на какую-то др.--%>
<form action="/logout", method="get" >
    <div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
</form>


</body>
</html>
