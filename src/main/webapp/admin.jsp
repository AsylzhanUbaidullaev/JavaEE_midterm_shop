<%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 15.03.2021
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%-- page directive --%>
<%@ page import="java.util.Date" %>
<form action="admin" method="GET">

    UserName :  <input type="text" name="username" /><br />

    Password :&nbsp; &nbsp; <input type="password" name="password" /><br />

    <input type="submit" value="login" />
    <p> Today is: <%= new Date() %> </p>
</form>
</body>
</html>
