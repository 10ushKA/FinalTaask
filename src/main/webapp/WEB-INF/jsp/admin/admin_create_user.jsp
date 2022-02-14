<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.02.2022
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <style><%@include file="/WEB-INF/css/form.css"%></style>
</head>
<body>
<form method="post" action="admin?command=create-client">


    <div class = "form_group">
        <input class = "form_input" name="username" id="username" placeholder="">
        <label class="form_label">User Name</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" name="first_name" id="first_name" placeholder="">
        <label class="form_label">First Name</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" name="last_name" id="last_name" placeholder="">
        <label class="form_label">Last Name</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" name="weight" type="number" id="weight" placeholder="">
        <label class="form_label">Weight</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" type="number" id="height" name="height" placeholder="">
        <label class="form_label">Height</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" type="number" id="age" name="age" placeholder="">
        <label class="form_label">Height</label>
    </div>

    <div class = "form_group">
        <input class = "form_input" name="password" type = "password" id = "password">
        <label class="form_label">password</label>
        <br>
        <label id="passwordText">Show password</label>

        <input type ="checkbox" id = "togglePassword">
        <script type="text/javascript">
            <%@include file="/WEB-INF/js/loginShowPass.js"%>
        </script>

        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>

        <br><br>
        <button type="submit" class="form_button">CREATE</button>
    </div>
</form>
</body>
</html>
