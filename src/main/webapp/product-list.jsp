<%@ page import="java.util.List" %>
<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.model.User" %>
<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.model.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 15.03.2021
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List with DB</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
<%@ include file = "header.jsp" %>

<ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
           class="nav-link">Products</a></li>
</ul>


<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/ProductServlet/new" class="btn btn-success">Add
                New Product</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Color</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="product" items="${listProduct}">

                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
<%--                    <td><c:out value="${product.description}" /></td>--%>
                    <td><c:out value="${product.image_link}" /></td>
                    <td><c:out value="${product.color}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>














<%--<%--%>
<%--//    String name = resultSet--%>
<%--%>--%>
<%--<c:forEach var="p" items="${products}">--%>
<%--    <br><br><br><br><br><br><br>--%>
<%--    <a>image</a>--%>
<%--<div class="block___ProductList___1lpGO">--%>
<%--    <div class="figure___Figure___2yTc1"><a href="/"><img--%>
<%--            src="${p.image_link}"--%>
<%--            alt="" class="img___Figure___1-pHN"></a>--%>
<%--        <div>--%>
<%--            <div class="block___Figure___2ostB">--%>
<%--                <div class="block___Sizes___2COUf"><h5 class="title___Sizes___2XltW">Размер</h5>--%>
<%--                    <div role="button" class="btn___SizeBtn___A4DSs">XS</div>--%>
<%--                    <div role="button" class="btn___SizeBtn___A4DSs">S</div>--%>
<%--                    <div role="button" class="btn___SizeBtn___A4DSs">M</div>--%>
<%--                    <div role="button" class="btn___SizeBtn___A4DSs disabled___SizeBtn___22O_N">L</div>--%>
<%--                    <div role="button" class="btn___SizeBtn___A4DSs disabled___SizeBtn___22O_N">XL</div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <a href="/">--%>
<%--        <div class="description___Description___3xwVo"><p--%>
<%--                class="title___Description___2qBc1 text___Text___2X-M-">${p.name}</p><em--%>
<%--                class="em___Description___tJzVm">${p.color}</em>--%>
<%--            <div class="price___Price___2jC3y"><span>${p.price}<!-- --> RUB</span></div>--%>
<%--        </div>--%>
<%--    </a></div>--%>

<%--</c:forEach>--%>
</body>
</html>
