<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 26.04.2021
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
           class="nav-link">Products</a></li>
</ul>

<br>
<%
    Product product;
%>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if var="product" test="${product != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${product == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${product != null}">
                                Edit Product
                            </c:if>
                            <c:if test="${product == null}">
                                Add New Product
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${product != null}">
                        <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Product Name</label> <input type="text"
                                                           value="<c:out value='${product.name}' />" class="form-control"
                                                           name="name" required="required">
                    </fieldset>

                    <%--                    <fieldset class="form-group">--%>
                    <%--                        <label>Product Description</label> <input type="text"--%>
                    <%--                                                         value="<c:out value='${product.description}' />" class="form-control"--%>
                    <%--                                                         name="description">--%>
                    <%--                    </fieldset>--%>

                    <fieldset class="form-group">
                        <label>Product Description</label> <input type="text"
                                                                  value="<c:out value='${product.image_link}' />" class="form-control"
                                                                  name="image_link">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Color</label> <input type="text"
                                                            value="<c:out value='${product.color}' />"
                                                            class="form-control"
                                                            name="color">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Price</label> <input type="text"
                                                            value="<c:out value='${product.price}' />"
                                                            class="form-control"
                                                            name="price">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
