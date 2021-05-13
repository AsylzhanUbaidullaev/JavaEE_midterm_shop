<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
</head>
<body>
<header>
    <jsp:useBean id="user" class="com.asylzhan.shop.JavaEE_midterm_shop.model.User" scope="session"/>
    <jsp:setProperty name="user" property="*"/>
    <div class="header___Header___3L22I">
        <div class="container___Header___2fzwa">
            <div class="logo___Header___YX1XE block___Logo___X8X26">
                <a href="index.jsp">
                    <img src="data:image/png;base64,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"
                         alt="" class="logo___Logo___1zkNN">
                </a>
            </div>
            <nav class="nav___Navigation___3sR2r">
                <ul class="list___Navigation___-RHSG">
                    <li class="item___Navigation___2cSmE">
                        <a class="a___Navigation___3Bzsr" href="AllProductsServlet"><span>MENS</span></a>
                    </li>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="old_jsp/product-list.jsp"><span>ACCESSORIES</span></a></li>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="about.jsp"><span>ABOUT US</span></a>
                    </li>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="gift-card.jsp"><span>GIFT CARD</span></a>
                    </li>
                    <% if (user.getEmail() == null) {%>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="login.jsp"><span>SIGN IN</span></a>
                    </li>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="registration.jsp"><span>REGISTRATION</span></a>
                    </li>
                    <%}
                    else if (user.getEmail() != null) {
                    %>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="profile.jsp"><span><jsp:getProperty name="user" property="name"/></span></a>
                    </li>
                    <li class="item___Navigation___2cSmE"><a class="a___Navigation___3Bzsr"
                                                             href="logout"><span>Logout</span></a>
                    </li>
                    <%}%>

                </ul>
            </nav>
            <div class="block___Actions___2XYLk">
                <div class="actions___Actions___2H4mm">
                    <!--          Search-->
                    <div class="search___Search___1jfop">
                        <label>
                            <input type="search" placeholder="Search" class="input___Search___2-nz0">
                            <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0nMS4wJyBlbmNvZGluZz0ndXRmLTgnPz4KPCFET0NUWVBFIHN2ZyBQVUJMSUMgJy0vL1czQy8vRFREIFNWRyAxLjEvL0VOJyAnaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkJz4KPHN2ZyBhcmlhLWhpZGRlbj0idHJ1ZSIgZm9jdXNhYmxlPSJmYWxzZSIgZGF0YS1wcmVmaXg9ImZhciIgZGF0YS1pY29uPSJzZWFyY2giIHJvbGU9ImltZyIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgY2xhc3M9InN2Zy1pbmxpbmUtLWZhIGZhLXNlYXJjaCBmYS13LTE2IGZhLTV4Ij48cGF0aCBmaWxsPSJjdXJyZW50Q29sb3IiIGQ9Ik01MDguNSA0NjguOUwzODcuMSAzNDcuNWMtMi4zLTIuMy01LjMtMy41LTguNS0zLjVoLTEzLjJjMzEuNS0zNi41IDUwLjYtODQgNTAuNi0xMzZDNDE2IDkzLjEgMzIyLjkgMCAyMDggMFMwIDkzLjEgMCAyMDhzOTMuMSAyMDggMjA4IDIwOGM1MiAwIDk5LjUtMTkuMSAxMzYtNTAuNnYxMy4yYzAgMy4yIDEuMyA2LjIgMy41IDguNWwxMjEuNCAxMjEuNGM0LjcgNC43IDEyLjMgNC43IDE3IDBsMjIuNi0yMi42YzQuNy00LjcgNC43LTEyLjMgMC0xN3pNMjA4IDM2OGMtODguNCAwLTE2MC03MS42LTE2MC0xNjBTMTE5LjYgNDggMjA4IDQ4czE2MCA3MS42IDE2MCAxNjAtNzEuNiAxNjAtMTYwIDE2MHoiIGNsYXNzPSIiPjwvcGF0aD48L3N2Zz4=" alt="search icon" role="closeIcon" class="searchButton___Search___2mGBV icon___IconButton___2ufl5">
                        </label>
                    </div>
                    <!--          Cabinet-->
                    <div class="icons___Icons___1xQoR">
                        <a class="userIcon___Icons___1GoRv" href="profile.jsp">
                            <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8c3ZnIGFyaWEtaGlkZGVuPSJ0cnVlIiBmb2N1c2FibGU9ImZhbHNlIiBkYXRhLXByZWZpeD0iZmFsIiBkYXRhLWljb249InVzZXIiIHJvbGU9ImltZyIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB2aWV3Qm94PSIwIDAgNDQ4IDUxMiIgY2xhc3M9InN2Zy1pbmxpbmUtLWZhIGZhLXVzZXIgZmEtdy0xNCBmYS0zeCI+PHBhdGggZmlsbD0iY3VycmVudENvbG9yIiBkPSJNMzEzLjYgMjg4Yy0yOC43IDAtNDIuNSAxNi04OS42IDE2LTQ3LjEgMC02MC44LTE2LTg5LjYtMTZDNjAuMiAyODggMCAzNDguMiAwIDQyMi40VjQ2NGMwIDI2LjUgMjEuNSA0OCA0OCA0OGgzNTJjMjYuNSAwIDQ4LTIxLjUgNDgtNDh2LTQxLjZjMC03NC4yLTYwLjItMTM0LjQtMTM0LjQtMTM0LjR6TTQxNiA0NjRjMCA4LjgtNy4yIDE2LTE2IDE2SDQ4Yy04LjggMC0xNi03LjItMTYtMTZ2LTQxLjZDMzIgMzY1LjkgNzcuOSAzMjAgMTM0LjQgMzIwYzE5LjYgMCAzOS4xIDE2IDg5LjYgMTYgNTAuNCAwIDcwLTE2IDg5LjYtMTYgNTYuNSAwIDEwMi40IDQ1LjkgMTAyLjQgMTAyLjRWNDY0ek0yMjQgMjU2YzcwLjcgMCAxMjgtNTcuMyAxMjgtMTI4UzI5NC43IDAgMjI0IDAgOTYgNTcuMyA5NiAxMjhzNTcuMyAxMjggMTI4IDEyOHptMC0yMjRjNTIuOSAwIDk2IDQzLjEgOTYgOTZzLTQzLjEgOTYtOTYgOTYtOTYtNDMuMS05Ni05NiA0My4xLTk2IDk2LTk2eiIgY2xhc3M9IiI+PC9wYXRoPjwvc3ZnPgo=" alt="user icon" role="link" class="icon___IconButton___2ufl5"></a>
                        <a class="userIcon___Icons___1GoRv" href="cart.jsp  ">
                        <span>
                            <img src="data:image/svg+xml;base64,PHN2ZyBhcmlhLWhpZGRlbj0idHJ1ZSIgZm9jdXNhYmxlPSJmYWxzZSIgZGF0YS1wcmVmaXg9ImZhbCIgZGF0YS1pY29uPSJzaG9wcGluZy1jYXJ0IiByb2xlPSJpbWciIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmlld0JveD0iMCAwIDU3NiA1MTIiIGNsYXNzPSJzdmctaW5saW5lLS1mYSBmYS1zaG9wcGluZy1jYXJ0IGZhLXctMTggZmEtM3giPjxwYXRoIGZpbGw9ImN1cnJlbnRDb2xvciIgZD0iTTU1MS45OTEgNjRIMTI5LjI4bC04LjMyOS00NC40MjNDMTE4LjgyMiA4LjIyNiAxMDguOTExIDAgOTcuMzYyIDBIMTJDNS4zNzMgMCAwIDUuMzczIDAgMTJ2OGMwIDYuNjI3IDUuMzczIDEyIDEyIDEyaDc4LjcybDY5LjkyNyAzNzIuOTQ2QzE1MC4zMDUgNDE2LjMxNCAxNDQgNDMxLjQyIDE0NCA0NDhjMCAzNS4zNDYgMjguNjU0IDY0IDY0IDY0czY0LTI4LjY1NCA2NC02NGE2My42ODEgNjMuNjgxIDAgMCAwLTguNTgzLTMyaDE0NS4xNjdhNjMuNjgxIDYzLjY4MSAwIDAgMC04LjU4MyAzMmMwIDM1LjM0NiAyOC42NTQgNjQgNjQgNjQgMzUuMzQ2IDAgNjQtMjguNjU0IDY0LTY0IDAtMTcuOTkzLTcuNDM1LTM0LjI0LTE5LjM4OC00NS44NjhDNTA2LjAyMiAzOTEuODkxIDQ5Ni43NiAzODQgNDg1LjMyOCAzODRIMTg5LjI4bC0xMi02NGgzMzEuMzgxYzExLjM2OCAwIDIxLjE3Ny03Ljk3NiAyMy40OTYtMTkuMTA1bDQzLjMzMS0yMDhDNTc4LjU5MiA3Ny45OTEgNTY3LjIxNSA2NCA1NTEuOTkxIDY0ek0yNDAgNDQ4YzAgMTcuNjQ1LTE0LjM1NSAzMi0zMiAzMnMtMzItMTQuMzU1LTMyLTMyIDE0LjM1NS0zMiAzMi0zMiAzMiAxNC4zNTUgMzIgMzJ6bTIyNCAzMmMtMTcuNjQ1IDAtMzItMTQuMzU1LTMyLTMyczE0LjM1NS0zMiAzMi0zMiAzMiAxNC4zNTUgMzIgMzItMTQuMzU1IDMyLTMyIDMyem0zOC4xNTYtMTkySDE3MS4yOGwtMzYtMTkyaDQwNi44NzZsLTQwIDE5MnoiIGNsYXNzPSIiPjwvcGF0aD48L3N2Zz4=" alt="package icon" role="link" class="icon___IconButton___2ufl5"><span class="cartCounter___Icons___Fh8hg">&nbsp;&nbsp;</span></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>
