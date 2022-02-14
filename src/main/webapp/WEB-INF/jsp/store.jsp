<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2022
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STORE</title>
</head>
<body>
<h3>STORE</h3>
<form action="/storeNew", method="post" >
<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Section</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${storeList}" var="store" >
        <tr>
            <td>${store.id}</td>
            <td>${store.item}</td>
            <td>${store.store_section}</td>
            <td>${store.price}</td>
            <td>
                <a href="editItem?id=${store.id}">Edit</a>
            </td>
            <td>
                <a href="deleteItem?id=${store.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
