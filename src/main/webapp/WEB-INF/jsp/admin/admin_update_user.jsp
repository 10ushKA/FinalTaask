<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <style><%@include file="/WEB-INF/css/custom_buttons.css"%></style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<a href="admin?command=to_admin_home" class="previous round">&#8249;</a>
    <h1>Update Client</h1>
<form method="post" action="admin?command=update-client">




    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
    <fieldset class="form-group">
        <label>User Name for update:</label> <input type="text" name="username" id="username" class="form-control" name="login" required="required">
    </fieldset>
    <fieldset class="form-group">
        <label>Password:</label> <input type="password" name="password" id="password" class="form-control" name="password">
    </fieldset>
                <br><br>
                <fieldset class="form-group">
                    <label>FirstName</label> <input type="text" name="first_name" id="first_name" class="form-control" name="password">
                </fieldset>

                <fieldset class="form-group">
                    <label>LastName</label> <input type="text" name="last_name" id="last_name" class="form-control" name="password">
                </fieldset>

                <fieldset class="form-group">
                    <label>Weight</label> <input type="number" name="weight" id="weight" class="form-control" name="password">
                </fieldset>

                <fieldset class="form-group">
                    <label>Height</label> <input type="number" name="height" id="height" class="form-control" name="password">
                </fieldset>

    <fieldset class="form-group">
        <label>Age</label> <input type="number" name="age" id="age" class="form-control" name="role">
    </fieldset>

    <button type="submit" style="background-color: #948a7d">Save</button>
    </div>
        </div>
    </div>
</form>
</body>
</html>
