<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
    <style><%@include file="/WEB-INF/css/custom_buttons.css"%></style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<a href="admin?command=to_admin_home" class="previous round" style="margin-right: 40px;">&#8249;</a>
    <form method="post" action="admin?command=delete-client">

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <fieldset class="form-group">
                        <label>User Name To Delete:</label> <input type="text" name="username" id="username" class="form-control" name="login" required="required">
                    </fieldset>

                    <button type="submit" class="form_button">DELETE</button>
                </div></div></div>


    </form>
</body>
</html>
