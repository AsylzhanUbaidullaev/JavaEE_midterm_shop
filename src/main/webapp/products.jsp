<%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 13.03.2021
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
<header>
    <%@include file="header.jsp"%>
</header> <br><br><br>
<main>
    <jsp:useBean id="productList" type="java.util.List<com.asylzhan.shop.JavaEE_midterm_shop.model.Product>" scope="request"/>
    <jsp:setProperty name="productList" property="*"/>
    <header class="menPage___Header___mMngb"><h5 class="subHead___Header___2w6oE">ROAD TO THE DREAM</h5>
        <h1> Мужчины</h1></header>
    <section class="wrapper___ProductList___14NKw">
        <div class="section___ProductList___34FN1">
            <div class="filterContainer___Filter___3kgWC">
                <div class="filterByCategory___Filter___2-8n7"><h4>Категории</h4>
                    <ul class="categories-container___CategoryList___1BHS_">
                        <li class="category___CategoryList___1O5wm"><a href="/mens/hoodies">Худи и свитшоты</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/t-shirt">Футболки и Майки</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/longsleeves">Лонгсливы</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/bottoms">Штаны</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/shorts">Шорты</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/sleeveless-shirt">Безрукавки</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/outlet">OUTLET</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/focus">Focus коллекция</a></li>
                        <li class="category___CategoryList___1O5wm"><a href="/mens/bold">Bold коллекция</a></li>
                        <li class="category___CategoryList___1O5wm"><a
                                href="/mens/vests/road-to-the-dream-vest">Жилет</a></li>
                    </ul>
                    <div><h4>Фильтр по размеру</h4>
                        <div class="categories-container___CategoryList___1BHS_">
                            <div class="buttonSizeContainer___CategoryList___bHq2-"><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=XS">XS</a><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=S">S</a><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=M">M</a><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=L">L</a><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=XL">XL</a><a
                                    class="buttonSize___CategoryList___Lxgoq" href="/mens?size=XXL">XXL</a></div>
                            <h4>По цвету</h4>
                            <div class="buttonSizeContainer___CategoryList___bHq2-"><a
                                    style="background:#000000;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=2"><span></span></a><a
                                    style="background:#c0c0c0;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=4"><span></span></a><a
                                    style="background:#b73833;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=5"><span></span></a><a
                                    style="background:#0e644f;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=11"><span></span></a><a
                                    style="background:#b9b900;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=15"><span></span></a><a
                                    style="background:#f5f50a;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=19"><span></span></a><a
                                    style="background:#ff9122;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=20"><span></span></a><a
                                    style="background:#8ab36f;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=21"><span></span></a><a
                                    style="background:#556526;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=25"><span></span></a><a
                                    style="background:#e8ed81;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=27"><span></span></a><a
                                    style="background:#6fc7ce;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=28"><span></span></a><a
                                    style="background:#d2d088;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=29"><span></span></a><a
                                    style="background:#7eabdc;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=30"><span></span></a><a
                                    style="background:#98faf0;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=31"><span></span></a><a
                                    style="background:#454545;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=33"><span></span></a><a
                                    style="background:#b0bfae;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=36"><span></span></a><a
                                    style="background:#904d30;border:2px #fff solid"
                                    class="buttonColor___CategoryList___3pU16" href="/mens?color=37"><span></span></a>
                            </div>
                            <a class="clearButton___CategoryList___3haLB" href="/mens">Очистить фильтр</a></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section___ProductList___34FN1">
            <div>
                <div class="filterButton___FilterMenu___1DsIB">Фильтр<img
                        src="data:image/svg+xml;base64,PHN2ZyBhcmlhLWhpZGRlbj0idHJ1ZSIgZm9jdXNhYmxlPSJmYWxzZSIgZGF0YS1wcmVmaXg9ImZhcyIgZGF0YS1pY29uPSJmaWx0ZXIiIHJvbGU9ImltZyIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgY2xhc3M9InN2Zy1pbmxpbmUtLWZhIGZhLWZpbHRlciBmYS13LTE2IGZhLTJ4Ij48cGF0aCBmaWxsPSJjdXJyZW50Q29sb3IiIGQ9Ik00ODcuOTc2IDBIMjQuMDI4QzIuNzEgMC04LjA0NyAyNS44NjYgNy4wNTggNDAuOTcxTDE5MiAyMjUuOTQxVjQzMmMwIDcuODMxIDMuODIxIDE1LjE3IDEwLjIzNyAxOS42NjJsODAgNTUuOThDMjk4LjAyIDUxOC42OSAzMjAgNTA3LjQ5MyAzMjAgNDg3Ljk4VjIyNS45NDFsMTg0Ljk0Ny0xODQuOTdDNTIwLjAyMSAyNS44OTYgNTA5LjMzOCAwIDQ4Ny45NzYgMHoiIGNsYXNzPSIiPjwvcGF0aD48L3N2Zz4="
                        class="iconButton___FilterMenu___1D_4A"></div>
                <div class="FilterMenu___FilterMenu___1SF7k">
                    <div class="over___FilterMenu___2dykl"></div>
                    <div class="Menu___FilterMenu___17LC1">
                        <div class="categories-container___CategoryList___3kVPF">
                            <div><h4>По размерам</h4>
                                <div class="buttonSizeContainer___CategoryList___nBBMD"><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=XS">XS</a><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=S">S</a><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=M">M</a><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=L">L</a><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=XL">XL</a><a
                                        class="buttonSize___CategoryList___yH2Y0" href="/mens?size=XXL">XXL</a></div>
                                <h4>По цвету</h4>
                                <div class="buttonSizeContainer___CategoryList___nBBMD"><a
                                        style="background:#000000;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=2"><span></span></a><a
                                        style="background:#c0c0c0;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=4"><span></span></a><a
                                        style="background:#b73833;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=5"><span></span></a><a
                                        style="background:#0e644f;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=11"><span></span></a><a
                                        style="background:#b9b900;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=15"><span></span></a><a
                                        style="background:#454545;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=33"><span></span></a><a
                                        style="background:#b0bfae;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=36"><span></span></a><a
                                        style="background:#904d30;border:2px #fff solid"
                                        class="buttonColor___CategoryList___1C13n"
                                        href="/mens?color=37"><span></span></a></div>
                                <a class="clearButton___CategoryList___1OGdQ" href="/mens">Очистить фильтр</a></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product-container___ProductList___1pSas">

                <% for (int i = 0; i < productList.size(); i++) {%>
                <div class="block___ProductList___1lpGO">
                    <div class="figure___Figure___2yTc1"><a href="ProductDetailServlet?&productId=<%=productList.get(i).getId()%>">
                        <img src="<%=productList.get(i).getImgLink()%>" alt="" class="img___Figure___1-pHN">
                        <img src="<%=productList.get(i).getImgLink2()%>" alt="" class="secondImg___Figure___3zeSP">
                    </a>
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
                    <a href="/mens/hoodies/rabotaembronze">
                        <div class="description___Description___3xwVo"><p
                                class="title___Description___2qBc1 text___Text___2X-M-"><%out.print(productList.get(i).getName());%></p><em
                                class="em___Description___tJzVm"><%out.print(productList.get(i).getColor());%></em>
                            <div class="price___Price___2jC3y"><span><%out.print(productList.get(i).getPrice());%> tg</span></div>
                        </div>
                    </a></div>
                <%}%>

            </div>
        </div>
    </section>
</main>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
