<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
<header>
    <%@include file="header.jsp"%>
</header>
<%HttpSession session1 = request.getSession();
    if (session1.getAttribute("cart") == null){
%>
<main>
    <div style="margin-top: 100px">
        <div class="cartPage___CartPage___32JAV"><div class="Cart_header__container___Navbar___MXF0f">
            <div class="Header___Navbar___1MY15">Ваша корзина</div>
        </div>
            <div class="Product__container___ProductsList___MJrgO">


                <div class="Product_price__container___ProductsList___1fe3M">
                    <div class="amountTitle___ProductsList___KvEld">Всего</div>
                    <div class="amountSum___ProductsList___q3pbS">0 тг</div>
                </div><div class="Product_ch_btn__container___ProductsList___14nQR">
            </div>
            </div>
            <div class="checkoutButton___CartPage___1CK8m">
                <div class="button___Button___1DznK">
                </div>
            </div>
        </div>
    </div>
</main>
<%}%>
<% if (session1.getAttribute("cart") != null) { %>
<main>
    <jsp:useBean id="cart" type="java.util.List<com.asylzhan.shop.JavaEE_midterm_shop.model.Cart>" scope="session"/>
    <jsp:setProperty name="cart" property="*"/>
    <%! double total = 0; %>
    <div style="margin-top: 100px">
        <div class="cartPage___CartPage___32JAV"><div class="Cart_header__container___Navbar___MXF0f">
            <div class="Header___Navbar___1MY15">Ваша корзина</div>
        </div>
            <div class="Product__container___ProductsList___MJrgO">
                <%for (int i = 0; i<cart.size(); i++) {%>
                <div class="cartItem___Product___1LsW0">
                    <div class="cartItemContainerImgText___Product___28t18">
                        <div class="imageContainer___Product___38dL-">
                            <a href="/mens/hoodies/hoodyundercoverblack">
                                <img src="<%=cart.get(i).getProduct().getImgLink()%>">
                            </a>
                        </div>
                        <div class="infoContainer___Product___1b7MF">
                            <div class="infoGood___Product___1RCSs">
                                <h2><%=cart.get(i).getProduct().getName()%></h2>
                                <h3><%=cart.get(i).getProduct().getColor()%></h3>
                                <div class="cartInfo___Product___3m00G">
                                    <p>S</p><span><%=cart.get(i).getProduct().getPrice()%> tg</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cartItemContainerCartButtons___Product___30p6U">
                        <div>
                            <a href="${pageContext.request.contextPath }/DeleteFromServlet?&id=<%=cart.get(i).getProduct().getId()%>" class="removeButton___Buttons___2_ZTL">Удалить</a>
                        </div>
                    </div>
                    <div class="cartItemContainerPrice___Product___3NFrP">
                        <span><%=cart.get(i).getProduct().getPrice()%> tg</span>
                    </div></div>
                <% total += cart.get(i).getProduct().getPrice(); %>
                <%}%>
                <div class="Product_price__container___ProductsList___1fe3M">
                    <div class="amountTitle___ProductsList___KvEld">Всего</div>
                    <div class="amountSum___ProductsList___q3pbS"><%=total%> тг</div>
                </div><div class="Product_ch_btn__container___ProductsList___14nQR">
            </div>
            </div>
            <div class="checkoutButton___CartPage___1CK8m">
                <div class="button___Button___1DznK">
                    <a href="index.jsp">Оформить заказ</a>
                </div>
            </div>
        </div>
    </div>
</main>
<%}%>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
