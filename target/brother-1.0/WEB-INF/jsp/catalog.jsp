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

    <title>PMarket</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/green.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/animate.min.css">

    <!-- Demo Purpose Only. Should be removed in production -->
    <link rel="stylesheet" href="resources/assets/css/config.css">

    <link href="${pageContext.request.contextPath}/resources/assets/css/green.css" rel="alternate stylesheet"
          title="Green color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/blue.css" rel="alternate stylesheet"
          title="Blue color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/red.css" rel="alternate stylesheet"
          title="Red color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/orange.css" rel="alternate stylesheet"
          title="Orange color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/navy.css" rel="alternate stylesheet"
          title="Navy color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/dark-green.css" rel="alternate stylesheet"
          title="Darkgreen color">
    <!-- Demo Purpose Only. Should be removed in production : END -->

    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">

    <!-- Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/images/eftech.ico">
</head>
<body>
<div class="wrapper">
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/header.jsp" %>
    <div id="top-mega-nav">
        <div class="container">
            <nav>
                <ul class="inline">
                    <li class="breadcrumb-nav-holder">
                        <ul>
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/">
                                    <local:message code="catalog.label.main"/>
                                </a>
                            </li>
                            <li class="breadcrumb-item current">
                                <a href="#">
                                    <local:message code="catalog.label.catalog"/>
                                </a>
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
        <c:if test="${not empty listProducts}">
        <c:if test="${listProducts[0].type == 'Plywood'}">
            <jsp:include page="/WEB-INF/jsp/catalog.sort/plywoodsort.jsp"/>
        </c:if>
        <c:if test="${listProducts[0].type == 'Robot'}">
            <jsp:include page="/WEB-INF/jsp/catalog.sort/robot.jsp"/>
        </c:if>
        <c:if test="${listProducts[0].type == 'ParticleBoard'}">
            <jsp:include page="/WEB-INF/jsp/catalog.sort/particleboard.jsp"/>
        </c:if>
        </c:if>
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
                                    <c:forEach items="${listProducts}" var="product">
                                        <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">
                                            <div class="product-item">
                                                <div class="ribbon red"><span>В продаже</span></div>
                                                <div class="image">
                                                    <img src="/getImage?image=${product.photoList[0].photo}"
                                                         alt="" width="246" height="186"/>
                                                </div>
                                                <div class="body">
                                                    <div class="title">
                                                        <a href="product/${product.productId}">${product.productId}</a>
                                                    </div>
                                                    <div class="brand">${product.type} </div>
                                                </div>
                                                <div class="prices">
                                                    <div class="price-prev">${product.price}</div>
                                                </div>
                                                <div class="hover-area">
                                                    <div class="add-cart-button">
                                                        <a href="addtobasket/${product.productId}"
                                                           class="le-button">в корзину</a>
                                                    </div>
                                                    <div class="wish-compare">
                                                        <a class="btn-add-to-compare"
                                                           href="add-product-to-compare-list.htm?id=${product.productId}">сравнить</a>
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
                                                <li><a href="/page?pageNumber=${i}">${i}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="list-view" class="products-grid fade tab-pane ">
                            <div class="products-list">
                                <c:forEach items="${listProducts}" var="product">
                                    <div class="product-item product-item-holder">
                                        <div class="ribbon red"><span>sale</span></div>
                                        <div class="ribbon blue"><span>new!</span></div>
                                        <div class="row">
                                            <div class="no-margin col-xs-12 col-sm-4 image-holder">
                                                    <%--<div class="image">
                                                        <img src="/resources/dataServer/${product.photoList[0].photo}"
                                                             width="246" height="186"/>
                                                    </div>--%>
                                            </div>
                                            <div class="no-margin col-xs-12 col-sm-5 body-holder">
                                                <div class="body">
                                                    <div class="label-discount green">-10% sale</div>
                                                    <div class="title">
                                                        <a href="product/${product.productId}">${product.productId}</a>
                                                    </div>
                                                    <div class="brand">${product.productId}
                                                        <br>
                                                    </div>
                                                    <div class="excerpt">
                                                        <p>${product.productId}</p>
                                                    </div>
                                                    <div class="addto-compare">
                                                        <a class="btn-add-to-compare"
                                                           href="add-product-to-compare-list.htm?id=${product.productId}">add
                                                            to compare list</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="no-margin col-xs-12 col-sm-3 price-area">
                                                <div class="right-clmn">

                                                    <div class="availability"><label>availability:</label><span
                                                            class="available">  in stock</span></div>
                                                    <a class="le-button"
                                                       href="add-product-to-customer-basket.htm?id=${product.productId}">add
                                                        to cart</a>
                                                    <a class="btn-add-to-wishlist"
                                                       href="add-product-to-wish-list.htm?id=${product.productId}">add
                                                        to
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