<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.model.User" %>
<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.controller.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="style/index.css">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- FontAwesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <!-- Custom Css -->
    <link rel="stylesheet" href="style/profile.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<!-- Main -->
<div class="main">
    <h2>IDENTITY</h2>
    <div class="card">
        <div class="card-body">
            <i class="fa fa-pen fa-xs edit"></i>
            <%--statement scriplet --%>
            <%
//                HttpSession httpSession = request.getSession();
//                User user = (User) httpSession.getAttribute("user");
//                if (user == null) {

                String email = request.getParameter("email");
                String name = request.getParameter("firstName");
                String password = request.getParameter("password");

            %>
            <table>
                <tbody>
<%--                <tr>--%>
<%--                    <td>Name</td>--%>
<%--                    <td>:</td>--%>
<%--                    <td><%=user.getName()%></td>--%>
<%--                </tr>--%>

<%--                 expression statement--%>
                <tr>
                    <td>Email</td>
                    <td>:</td>
                    <td><%=email%></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><%=password%></td>
                </tr>
                <tr>
                    <td>Orders</td>
                    <td>:</td>
                    <td>-</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- End -->
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
