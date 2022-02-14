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
</head>
<body>
    <h1>Welcome!</h1>
    <a href="admin?command=to-all-clients"><button>Show all clients</button></a>
    <a href="admin?command=to-create-client"><button>Create Client</button></a>
    <a href="admin?command=to-update-client"><button>Update client</button></a>
    <a href="admin?command=to-delete-client"><button>Delete client</button></a>
    <br><br>
    <a href="/home?command=to_login"><button>LOGOUT</button></a>
</body>
</html>
