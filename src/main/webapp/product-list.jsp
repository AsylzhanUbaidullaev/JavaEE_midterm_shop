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
</head>
<body>
<%
//    String name = resultSet
%>
<c:forEach var="p" items="${products}">
<div class="block___ProductList___1lpGO">
    <div class="figure___Figure___2yTc1"><a href="/"><img
            src="${p.imagelink}"
            alt="" class="img___Figure___1-pHN"></a>
        <div>
            <div class="block___Figure___2ostB">
                <div class="block___Sizes___2COUf"><h5 class="title___Sizes___2XltW">Размер</h5>
                    <div role="button" class="btn___SizeBtn___A4DSs">XS</div>
                    <div role="button" class="btn___SizeBtn___A4DSs">S</div>
                    <div role="button" class="btn___SizeBtn___A4DSs">M</div>
                    <div role="button" class="btn___SizeBtn___A4DSs disabled___SizeBtn___22O_N">L</div>
                    <div role="button" class="btn___SizeBtn___A4DSs disabled___SizeBtn___22O_N">XL</div>
                </div>
            </div>
        </div>
    </div>
    <a href="/">
        <div class="description___Description___3xwVo"><p
                class="title___Description___2qBc1 text___Text___2X-M-">${p.name}</p><em
                class="em___Description___tJzVm">${p.color}</em>
            <div class="price___Price___2jC3y"><span>${p.price}<!-- --> RUB</span></div>
        </div>
    </a></div>
</c:forEach>
</body>
</html>
