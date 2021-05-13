<%@ page import="com.asylzhan.shop.JavaEE_midterm_shop.model.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 25.04.2021
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INFORMATION ABOUT PRODUCT</title>
    <link rel="stylesheet" href="style/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>

<header>
    <%@include file="header.jsp"%>
</header> <br><br><br>
<main>
    <jsp:useBean id="product" class="com.asylzhan.shop.JavaEE_midterm_shop.model.Product" scope="request"/>
    <jsp:setProperty name="product" property="*"/>
    <div>
        <div class="ProductPage___ProductPage___2fdsw">
            <div></div>
            <nav class="product__container__breadcrumps___ProductPage___1bTfm"><span><a href="index.jsp">Главная</a></span>
                <span aria-hidden="true" class="divider___ProductPage___2T7sN">/</span>
                <a href="products.jsp">Мужчины</a><span aria-hidden="true" class="divider___ProductPage___2T7sN">/</span>

                <span><%=product.getName()%></span></nav>
            <div class="product__container___ProductPage___1kzAd">
                <div class="product__container__image___ProductPage___yhvGt">
                    <div>
                        <div class="img-third___Images___2ed0E">
                            <img src="<%=product.getImgLink2()%>" alt="" class="img___Images___lXIzt">
                            <img src="<%=product.getImgLink()%>" alt="" class="img___Images___lXIzt">
                            <img src="<%=product.getImgLink2()%>" alt="" class="img___Images___lXIzt"></div>
                        <div class="img-first___Images___1Dp2-"><img src="<%=product.getImgLink()%>" alt="" class="img___Images___lXIzt">
                        </div>
                    </div>
                </div>
                <div class="product__container__information___ProductPage___3nDrh">
                    <div class="information__block___Information___pClFC">
                        <h1><%=product.getName()%></h1>
                        <h4><%=product.getColor()%></h4>
                        <h3 class="priceBlock___Information___WxkP9">
                            <div data-price-wrapper="">
                                <span data-product-price=""><%=product.getPrice()%> тг</span>
                            </div></h3><div class="product__colors___Colors___1FyUd">

                    </div>
                        <div>
                            <div class="but__prod___Information___2zVMk"><div>
                                <h4>Размер </h4>
                                <div style="width: auto; margin: auto;">
                                    <div role="button" subcategory="hoodies" class="btn___SizeBtn___3QVOO">XS</div>
                                    <div role="button" subcategory="hoodies" class="btn___SizeBtn___3QVOO">S</div>
                                    <div role="button" subcategory="hoodies" class="btn___SizeBtn___3QVOO">M</div>
                                    <div role="button" subcategory="hoodies" class="btn___SizeBtn___3QVOO">L</div>
                                    <div role="button" subcategory="hoodies" class="btn___SizeBtn___3QVOO">XL</div>
                                </div></div></div><div class="showTableSizes___Information___1rO1B">Подбор размера</div>
                            <form>
                                <a href="${pageContext.request.contextPath }/CartServlet?&product_id=<%=product.getId()%>"><button type="button" class="button___Button___1DznK skew___Button___313Bu">В корзину</button></a>
                            </form>
                        </div>
                        <div class="information__block__description___Information___KWE9m">
                            <p><%=product.getDescription()%></p>
                            <ul>
                                <li>Маска всегда с тобой</li>
                                <li>Высокий воротник-стойка защитит от ветра </li>
                                <li>Рукава с прорезями для комфортных тренировок на улице </li>
                                <li>Логотип в новой графике </li>
                                <li>Ткань высокой плотности хорошо сохраняет тепло и не портится при стирке </li>
                                <li>Подойдет для спорта и на каждый день </li>
                            </ul>
                            <hr style="size: 1; color: #9b9b9b">
                            <p>Если у вас остаются сомнения по поводу выбора размера, рекомендуем обратиться в службу поддержки.</p>
                            <hr style="size: 1; color: #9b9b9b">
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <h4>Оставить отзыв</h4>
                <div>
                    <% for (Comment comment: product.getCommentList()) {%>
                    <div style="background: #eeeeee">
                        <b><p style="color: black;"><%=comment.getUser().getName()%> </b><small style="color: #999999">14 May 2021</small></p>
                        <p> <%=comment.getComment()%></p>
                    </div><br>
                    <%}%>
                    <hr style="size: 1; color: #9b9b9b">
                    <%if (user.getName()!=null){%>
                    <form action="CommentServlet" method="post">
                        <div class="form-floating">
                            <input type="hidden" name="product_id" value="<%=product.getId()%>">
                            <input type="hidden" name="userId" value="<%=user.getId()%>">
                            <textarea class="form-control" name="comment" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
                            <label for="floatingTextarea2">Comments</label><br>
                            <button type="submit" class="btn btn-secondary">Send</button>
                        </div>

                    </form>
                    <%}%>
                    <%if (user.getName()==null){%>
                    <form action="">
                        <div class="form-floating">
                            <textarea class="form-control" name="comment" placeholder="Login first" id="floatingTextarea" style="height: 100px" readonly></textarea>
                            <label for="floatingTextarea">Comments</label>
                        </div><br>
                        <a href="login.jsp" class="btn btn-secondary">Send</a>
                    </form>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
