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
<form action="/logout" method="get" >
<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
</form>
<h3>Create Item</h3>

<p style="color: red;">${errorString}</p>

<form method="post" action="${pageContext.req.contextPath}/createItem">
    <table border="0">
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${store.id}" /></td>
        </tr>
        <tr>
            <td>Item Name</td>
            <td><input type="text" name="item" value="${store.item}" /></td>
        </tr>
        <tr>
            <td>Section</td>
            <td><input type="text" name="store_section" value="${store.store_section}" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${store.price}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="../store.jsp">Cancel</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
