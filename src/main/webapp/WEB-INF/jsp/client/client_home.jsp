<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User Page</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>

<body>
<header>
    <a href="" class="logo">MY DIGITAL WARDROBE</a>
    <nav>
        <ul class="topmenu">
            <li><a href="" class="submenu-link">MENU</a>
                <ul class="submenu">
                    <li><a href="">WHAT'S NEW</a></li>
                    <li><a href="">MY WARDROBE</a></li>
                    <li><a href="store.jsp">STORE</a></li>
                </ul>
            </li>
            <li><a href="">ABOUT US</a></li>
            <li><a href="">MY CART</a></li>
        </ul>
    </nav>

    <div>

    </div>
</header>


    <h2>User's HomePage</h2>
Welcome <%=request.getSession().getAttribute("username") %>
    <div style="text-align: right"><a href="/home?command=to_login"><button>LOGOUT</button></a></div>

</body>
</html>



