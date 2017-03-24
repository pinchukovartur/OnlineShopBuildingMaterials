<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
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

    <title>Product</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/static/assets/css/bootstrap.min.css"/>">

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="<c:url value="/static/assets/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/green.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/owl.carousel.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/owl.transitions.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/animate.min.css"/>">

    <!-- Demo Purpose Only. Should be removed in production -->
    <link rel="stylesheet" href="<c:url value="/static/assets/css/config.css"/>">

    <link href="<c:url value="/static/assets/css/green.css"/>" rel="alternate stylesheet" title="Green color">
    <link href="<c:url value="/static/assets/css/blue.css"/>" rel="alternate stylesheet" title="Blue color">
    <link href="<c:url value="/static/assets/css/red.css"/>" rel="alternate stylesheet" title="Red color">
    <link href="<c:url value="/static/assets/css/orange.css"/>" rel="alternate stylesheet" title="Orange color">
    <link href="<c:url value="/static/assets/css/navy.css"/>" rel="alternate stylesheet" title="Navy color">
    <link href="<c:url value="/static/assets/css/dark-green.css"/>" rel="alternate stylesheet" title="Darkgreen color">
    <!-- Demo Purpose Only. Should be removed in production : END -->


    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="<c:url value="/static/assets/css/font-awesome.min.css"/>">

    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value="/static/assets/images/favicon.ico"/>">

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
                                <a href="/">Главная</a>
                            </li>
                            <li class="breadcrumb-item current">
                                <a href="">${product.productName}</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>     <div id="single-product">
    <div class="container">

        <div class="no-margin col-xs-12 col-sm-6 col-md-5 gallery-holder">
            <div class="product-item-holder size-big single-product-gallery small-gallery">

                <div id="owl-single-product">
                    <c:forEach items="${product.photos}" var="photo">
                    <div class="single-product-gallery-item" id="slide1">
                        <a data-rel="prettyphoto" href="/media/${photo.photoName}">
                            <img alt=""
                                 src="/media/${photo.photoName}"
                                 width="276" height="206"/>
                        </a>
                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="nav-holder left hidden-xs">
                <a class="prev-btn slider-prev" data-target="#owl-single-product-thumbnails" href="#prev"></a>
            </div>
            <div class="nav-holder right hidden-xs">
                <a class="next-btn slider-next" data-target="#owl-single-product-thumbnails" href="#next"></a>
            </div>
        </div>
    </div>
</div>
</div>





</div>
<section id="single-product-tab">
    <div class="container">
        <div class="tab-holder">

            <ul class="nav nav-tabs simple" >
                <li class="active"><a href="#description" data-toggle="tab">Описание</a></li>
                <li><a href="#additional-info" data-toggle="tab">Характеристики</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="description">
                    <p>${product.description}</p>

                    <div class="meta-row">
                        <div class="inline">
                            <label>SKU:</label>
                            <span>54687621</span>
                        </div>

                        <span class="seperator">/</span>

                        <div class="inline">
                            <label>categories:</label>
                            <!--<span><a href="#">-50% sale</a>,</span>-->
                            <span><a href="#">gaming</a>,</span>
                            <span><a href="#">desktop PC</a></span>
                        </div>

                        <span class="seperator">/</span>

                        <div class="inline">
                            <label>tag:</label>
                            <span><a href="#">fast</a>,</span>
                            <span><a href="#">gaming</a>,</span>
                            <span><a href="#">strong</a></span>
                        </div>
                    </div>
                </div>

                <div class="tab-pane" id="additional-info">

                    <ul class="tabled-data">
                        <li>
                            <label>Название продукта:</label>
                            <div class="value">${product.productName}</div>
                        </li>
                        <li>
                            <label>Цена:</label>
                            <div class="value">${product.price}</div>
                        </li>
                        <%--@elvariable id="attributeSize" type="int"--%>
                        <c:forEach items="${product.values}" var="value">
                            <li>
                                <label>${value.attribute.attributeName}:</label>
                                <div class="value">${value.value}</div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="meta-row">
                        <div class="inline">
                            <label>SKU:</label>
                            <span>54687621</span>
                        </div><!-- /.inline -->

                        <span class="seperator">/</span>

                        <div class="inline">
                            <label>categories:</label>
                            <span><a href="#">gaming</a>,</span>
                            <span><a href="#">desktop PC</a></span>
                        </div><!-- /.inline -->

                        <span class="seperator">/</span>

                        <div class="inline">
                            <label>tag:</label>
                            <span><a href="#">fast</a>,</span>
                            <span><a href="#">gaming</a>,</span>
                            <span><a href="#">strong</a></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="includes/footer.jsp" %>

<script src="<c:url value="/static/assets/js/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/jquery-migrate-1.2.1.js"/>"></script>
<script src="<c:url value="/static/assets/js/bootstrap.min.js"/>"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="<c:url value="/static/assets/js/gmap3.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/bootstrap-hover-dropdown.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/css_browser_selector.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/echo.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/jquery.easing-1.3.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/bootstrap-slider.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/jquery.raty.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/jquery.prettyPhoto.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/jquery.customSelect.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/wow.min.js"/>"></script>
<script src="<c:url value="/static/assets/js/scripts.js"/>"></script>
<script src="<c:url value="/static/assets/switchstylesheet/switchstylesheet.js"/>"></script>
<script>
    $(document).ready(function(){
        $(".changecolor").switchstylesheet( { seperator:"color"} );
        $('.show-theme-options').click(function(){
            $(this).parent().toggleClass('open');
            return false;
        });
    });
    $(window).bind("load", function() {
        $('.show-theme-options').delay(2000).trigger('click');
    });
</script>
<script src="http://w.sharethis.com/button/buttons.js"></script>
</body>
</html>