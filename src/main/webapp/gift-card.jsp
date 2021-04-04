<%--
  Created by IntelliJ IDEA.
  User: Swift3
  Date: 05.04.2021
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gift Card</title>
</head>
<body>
<header>
    <%-- Header (comment scriplet) & include directive--%>
<%--    <jsp:include page="header.jsp"/>--%>
        <%@ include file="header.jsp" %>
</header>
<div class="ProductPage___ProductPage___2fdsw">
    <div></div>
    <nav class="product__container__breadcrumps___ProductPage___1bTfm"><span><a href="/">Главная</a></span><span
            aria-hidden="true" class="divider___ProductPage___2T7sN">/</span><a href="/accessories">Аксессуары</a><span
            aria-hidden="true" class="divider___ProductPage___2T7sN">/</span><a href="/accessories/gift-cards">Подарочные
        карты</a><span aria-hidden="true" class="divider___ProductPage___2T7sN">/</span><span>Подарочная карта</span>
    </nav>
    <div class="product__container___ProductPage___1kzAd">
        <div class="product__container__image___ProductPage___yhvGt">
            <div>
                <div class="img-first___Images___1Dp2-"><img
                        src="https://admin.roadtothedream.com/images/products/lg/giftcard_5fe6cf409334b7.65657800.jpg"
                        alt="" class="img___Images___lXIzt"></div>
            </div>
        </div>
        <div class="product__container__information___ProductPage___3nDrh">
            <div class="information__block___Information___pClFC"><h1>Подарочная карта </h1><h4></h4>
                <h3 class="priceBlock___Information___WxkP9">
                    <div data-price-wrapper=""><span data-product-price="" class="salePrice___Information___3cj5n">12000.00 RUB</span>
                    </div>
                    <div data-price-wrapper=""><span data-product-price="">12000.00 RUB</span></div>
                </h3>
                <div>
                    <div class="but__prod___Information___2zVMk">
                        <div><h4>Номинал </h4>
                            <div style="width: 250px; margin: auto;">
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">500
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">1000
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">1500
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">2000
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">3000
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">5000
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO giftCard___SizeBtn___whmzP">10000
                                </div>
                                <div role="button" subcategory="gift-cards"
                                     class="btn___SizeBtn___3QVOO choosen___SizeBtn___3EvUb giftCard___SizeBtn___whmzP">
                                    12000
                                </div>
                            </div>
                        </div>
                    </div>
                    <form>
                        <button type="button" class="button___Button___1DznK skew___Button___313Bu">Купить</button>
                    </form>
                </div>
                <div class="information__block__description___Information___KWE9m"><p>Если вы хотите сделать подарок, но
                    не уверены что именно заказать, предоставьте возможность выбрать подарок самостоятельно с помощью
                    подарочной карты Road to the Dream!</p>
                    <ul>
                        <li>После покупки подарочной карты на указанный вами E-mail придёт сообщение со специальным
                            подарочным кодом и инструкциями по его использованию. Обратите внимание, мы не отправляем
                            физические карты, при этом вы сможете распечатать подарочную карту из письма в высоком
                            качестве. Это очень просто!
                        </li>
                        <li>Наши подарочные карты не имеют ограничения по сроку действия</li>
                        <li>Вы можете использовать карту сколько угодно раз пока баланс на ней не исчерпается</li>
                        <li>Подарочные карты не подлежат возврату</li>
                        <li>При покупке подарочной карты дополнительных платежей нет. При этом, оформляя заказ с
                            использованием подарочного кода, вам нужно будет оплатить услуги доставки отдельно
                        </li>
                    </ul>
                    <p>Более подробная информация <a href="https://roadtothedream.com/page/gft-crd">собрана здесь</a>
                    </p></div>
            </div>
        </div>
    </div>
</div>
<footer>
    <%-- Footer --%>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
