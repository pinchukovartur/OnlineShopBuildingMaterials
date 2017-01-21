<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="MediaCenter, Template, eCommerce">
    <meta name="robots" content="all">

    <title>MediaCenter - Responsive eCommerce Template</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="resources/assets/css/main.css">
    <link rel="stylesheet" href="resources/assets/css/green.css">
    <link rel="stylesheet" href="resources/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="resources/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="resources/assets/css/animate.min.css">

    <!-- Demo Purpose Only. Should be removed in production -->
    <link rel="stylesheet" href="resources/assets/css/config.css">

    <link href="resources/assets/css/green.css" rel="alternate stylesheet" title="Green color">
    <link href="resources/assets/css/blue.css" rel="alternate stylesheet" title="Blue color">
    <link href="resources/assets/css/red.css" rel="alternate stylesheet" title="Red color">
    <link href="resources/assets/css/orange.css" rel="alternate stylesheet" title="Orange color">
    <link href="resources/assets/css/navy.css" rel="alternate stylesheet" title="Navy color">
    <link href="resources/assets/css/dark-green.css" rel="alternate stylesheet" title="Darkgreen color">
    <!-- Demo Purpose Only. Should be removed in production : END -->

    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">

    <!-- Favicon -->
    <link rel="shortcut icon" href="resources/assets/images/favicon.ico">
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
</head>
<body>
<div class="wrapper">
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/header.jsp" %>
    <div id="top-mega-nav">
        <div class="container">
            <nav>
                <ul class="inline">
                    <%@include file="includes/dropdown le-dropdown.jsp" %>
                    <li class="breadcrumb-nav-holder">
                        <ul>
                            <li class="breadcrumb-item">
                                <a href="index.htm">Главная</a>
                            </li>
                            <li class="breadcrumb-item current">
                                <a href="#">IPhones</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<section id="category-grid">
    <div class="container">
        <div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
            <div class="widget">
                <h1>Фильтр Телефонов</h1>
                <form action="product_select" method="GET">
                    <input type="hidden" name="page" value="ru-allmachine">
                    <div class="body bordered">
                        <div class="category-filter">
                            <h2>Тип</h2>
                            <hr>
                            <ul>
                                <c:choose>
                                    <c:when test="${chIphone5c==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone5c' value='1'/> <label>iPhone 5c</label></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone5c'
                                                   value='1'/> <label>iPhone 5c</label></li>
                                    </c:otherwise>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${chIphone5s==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone5s' value='1'/> <label>iPhone 5s</label></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone5s'
                                                   value='1'/> <label>iPhone 5s</label></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${chIphone6==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone6' value='1'/> <label>iPhone 6</label></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone6'
                                                   value='1'/> <label>iPhone 6</label></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${chIphone6plus==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone6plus' value='1'/> <label>iPhone 6 Plus</label>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone6plus'
                                                   value='1'/> <label>iPhone 6 Plus</label></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${chIphone6s==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone6s' value='1'/> <label>iPhone 6 s</label></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone6s'
                                                   value='1'/> <label>iPhone 6 s</label></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${chIphone6splus==1}">
                                        <li><input checked="checked" class="le-checkbox" type="checkbox"
                                                   name='checkbox_iphone6splus' value='1'/> <label>iPhone 6s
                                            Plus</label></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><input class="le-checkbox" type="checkbox" name='checkbox_iphone6splus'
                                                   value='1'/> <label>iPhone 6s Plus</label></li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                        </div>

                        <div class="price-filter">
                            <h2>Цвет</h2>
                            <hr>
                            <div class="le-select">
                                <select name="color">
                                    <option disabled>Цвет</option>
                                    <c:choose>
                                        <c:when test="${color=='n'}">
                                            <option selected value="n">Не выбрано</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="n">Не выбрано</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${color=='зелёный'}">
                                            <option selected value="зелёный"> зелёный</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="зелёный"> зелёный</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${color=='золотой'}">
                                            <option selected value="золотой"> золотой</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="золотой"> золотой</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${color=='розовый'}">
                                            <option selected value="розовый"> розовый</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="розовый"> розовый</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${color=='серебристый'}">
                                            <option selected value="серебристый"> серебристый</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="серебристый"> серебристый</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${color=='серый космос'}">
                                            <option selected value="серый космос"> серый космос</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="серый космос"> серый космос</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>

                        <div class="price-filter">
                            <h2>Объём памяти</h2>
                            <hr>
                            <div class="le-select">
                                <select name="memory">
                                    <option disabled>Select Y</option>
                                    <c:choose>
                                        <c:when test="${memory=='n'}">
                                            <option selected value="n">Not important</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="n">Not important</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${memory=='8'}">
                                            <option selected value="8"> 8 ГБ</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="8"> 8 ГБ</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${memory=='16'}">
                                            <option selected value="16"> 16 ГБ</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="16"> 16 ГБ</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${memory=='32'}">
                                            <option selected value="32"> 32 ГБ</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="32"> 32 ГБ</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${memory=='64'}">
                                            <option selected value="64"> 64 ГБ</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="64"> 64 ГБ</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${memory=='128'}">
                                            <option selected value="128"> 128 ГБ</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="128"> 128 ГБ</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                        <hr>
                        <input type="submit" name="register" value="Выбрать телефон"/>
                    </div><!-- /.body -->
                </form>
            </div>
        </div>

        <div class="col-xs-12 col-sm-9 no-margin wide sidebar">
            <section id="gaming">
                <div class="grid-list-products">
                    <div class="control-bar">
                        <div class="grid-list-buttons">
                            <ul>
                                <li class="grid-list-button-item active"><a data-toggle="tab" href="#grid-view"><i
                                        class="fa fa-th-large"></i> Grid</a></li>
                                <li class="grid-list-button-item "><a data-toggle="tab" href="#list-view"><i
                                        class="fa fa-th-list"></i> List</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="grid-view" class="products-grid fade tab-pane in active">
                            <div class="product-grid-holder">
                                <div class="row no-margin">
                                    <c:forEach items="${listProduct}" var="iphone">
                                        <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">
                                            <div class="product-item">
                                                <div class="ribbon red"><span>В продаже</span></div>
                                                <div class="image">
                                                    <img alt="" src="resources/assets/images/blank.gif"
                                                         data-echo="resources/assets/images/products/${iphone.productId}"
                                                         width="246" height="186"/>
                                                </div>
                                                <div class="body">
                                                    <div class="title">
                                                        <a href="iphone-${iphone.productId}.htm">${iphone.productId} ${iphone.productId}</a>
                                                    </div>
                                                    <div class="brand">${iphone.type} </div>
                                                </div>
                                                <div class="prices">
                                                    <div class="price-prev">${iphone.price}</div>
                                                </div>
                                                <div class="hover-area">
                                                    <div class="add-cart-button">
                                                        <a href="add-product-to-customer-basket.htm?id=${iphone.productId}"
                                                           class="le-button">в корзину</a>
                                                    </div>
                                                    <div class="wish-compare">
                                                        <a class="btn-add-to-compare"
                                                           href="add-product-to-compare-list.htm?id=${iphone.productId}">сравнить</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="pagination-holder">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-6 text-left">
                                        <ul class="pagination ">

                                            <c:forEach var="i" begin="1" end="${numberOfPages}">
                                                <li class="current">
                                                <li><a href="/${i}">${i}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                            <div id="list-view" class="products-grid fade tab-pane ">
                            <div class="products-list">
                                <c:forEach items="${listProduct}" var="iphone">
                                    <div class="product-item product-item-holder">
                                        <div class="ribbon red"><span>sale</span></div>
                                        <div class="ribbon blue"><span>new!</span></div>
                                        <div class="row">
                                            <div class="no-margin col-xs-12 col-sm-4 image-holder">
                                                <div class="image">
                                                        <%--
                                                                                            <img alt="" src="resources/assets/images/blank.gif" data-echo="resources/assets/images/products/${iphone.photo1}"  width="246" height="186"/>
                                                        --%>
                                                </div>
                                            </div>
                                            <div class="no-margin col-xs-12 col-sm-5 body-holder">
                                                <div class="body">
                                                    <div class="label-discount green">-10% sale</div>
                                                    <div class="title">
                                                        <a href="iphone-${iphone.productId}.htm">${iphone.productId} ${iphone.productId}</a>
                                                    </div>
                                                    <div class="brand">${iphone.productId}
                                                        <br>
                                                    </div>
                                                    <div class="excerpt">
                                                        <p>${iphone.productId}</p>
                                                    </div>
                                                    <div class="addto-compare">
                                                        <a class="btn-add-to-compare"
                                                           href="add-product-to-compare-list.htm?id=${iphone.productId}">add
                                                            to compare list</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="no-margin col-xs-12 col-sm-3 price-area">
                                                <div class="right-clmn">

                                                    <div class="availability"><label>availability:</label><span
                                                            class="available">  in stock</span></div>
                                                    <a class="le-button"
                                                       href="add-product-to-customer-basket.htm?id=${iphone.productId}">add
                                                        to cart</a>
                                                    <a class="btn-add-to-wishlist"
                                                       href="add-product-to-wish-list.htm?id=${iphone.productId}">add to
                                                        wishlist</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</section>
<%@include file="includes/footer.jsp" %>
<script src="resources/assets/js/jquery-1.10.2.min.js"></script>
<script src="resources/assets/js/jquery-migrate-1.2.1.js"></script>
<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="resources/assets/js/gmap3.min.js"></script>
<script src="resources/assets/js/bootstrap-hover-dropdown.min.js"></script>
<script src="resources/assets/js/owl.carousel.min.js"></script>
<script src="resources/assets/js/css_browser_selector.min.js"></script>
<script src="resources/assets/js/echo.min.js"></script>
<script src="resources/assets/js/jquery.easing-1.3.min.js"></script>
<script src="resources/assets/js/bootstrap-slider.min.js"></script>
<script src="resources/assets/js/jquery.raty.min.js"></script>
<script src="resources/assets/js/jquery.prettyPhoto.min.js"></script>
<script src="resources/assets/js/jquery.customSelect.min.js"></script>
<script src="resources/assets/js/wow.min.js"></script>
<script src="resources/assets/js/scripts.js"></script>
<script src="resources/assets/switchstylesheet/switchstylesheet.js"></script>
<script>
    $(document).ready(function () {
        $(".changecolor").switchstylesheet({seperator: "color"});
        $('.show-theme-options').click(function () {
            $(this).parent().toggleClass('open');
            return false;
        });
    });

    $(window).bind("load", function () {
        $('.show-theme-options').delay(2000).trigger('click');
    });
</script>
<script src="http://w.sharethis.com/button/buttons.js"></script>
</body>
</html>