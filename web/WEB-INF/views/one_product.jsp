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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/green.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/animate.min.css">

    <!-- Demo Purpose Only. Should be removed in production -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/config.css">

    <link href="${pageContext.request.contextPath}/resources/assets/css/green.css" rel="alternate stylesheet" title="Green color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/blue.css" rel="alternate stylesheet" title="Blue color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/red.css" rel="alternate stylesheet" title="Red color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/orange.css" rel="alternate stylesheet" title="Orange color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/navy.css" rel="alternate stylesheet" title="Navy color">
    <link href="${pageContext.request.contextPath}/resources/assets/css/dark-green.css" rel="alternate stylesheet" title="Darkgreen color">
    <!-- Demo Purpose Only. Should be removed in production : END -->

    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">

    <!-- Favicon -->
    <link rel="shortcut icon" href="resources/assets/images/favicon.ico">


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
                                <a href="index.htm">Главная</a>
                            </li>
                            <li class="breadcrumb-item current">
                                <a href="">${product.productId}</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<div id="single-product">
    <div class="container">

        <div class="no-margin col-xs-12 col-sm-6 col-md-5 gallery-holder">
            <div class="product-item-holder size-big single-product-gallery small-gallery">

                <div id="owl-single-product">
                    <div class="single-product-gallery-item" id="slide1">
                        <a data-rel="prettyphoto" href="resources/assets/images/products/${iphone.photo1}">
                            <img class="img-responsive" alt=""
                                 src="resources/assets/images/products/${iphone.photo1}"
                                 data-echo="resources/assets/images/products/${iphone.photo1}" />

                        </a>
                    </div>

                    <div class="single-product-gallery-item" id="slide2">
                        <a data-rel="prettyphoto" href="resources/assets/images/products/${iphone.photo2}">
                            <img class="img-responsive" alt=""
                                 src="resources/assets/images/products/${iphone.photo2}"
                                 data-echo="resources/assets/images/products/${iphone.photo2}" />

                        </a>
                    </div>

                    <div class="single-product-gallery-item" id="slide3">
                        <a data-rel="prettyphoto" href="resources/assets/images/products/${iphone.photo3}">
                            <img class="img-responsive" alt=""
                                 src="resources/assets/images/products/${iphone.photo3}"
                                 data-echo="resources/assets/images/products/${iphone.photo3}" />
                        </a>
                    </div>
                </div>


                <div class="single-product-gallery-thumbs gallery-thumbs">

                    <div id="owl-single-product-thumbnails">
                        <a class="horizontal-thumb active" data-target="#owl-single-product" data-slide="0" href="#slide1">
                            <img width="67" alt="" src="resources/assets/images/products/${iphone.photo1}" data-echo="resources/assets/images/products/${iphone.photo1}" />
                        </a>
                        <a class="horizontal-thumb" data-target="#owl-single-product" data-slide="1" href="#slide2">
                            <img width="67" alt=""  src="resources/assets/images/products/${iphone.photo2}" data-echo="resources/assets/images/products/${iphone.photo2}"  />
                        </a>
                        <a class="horizontal-thumb" data-target="#owl-single-product" data-slide="2" href="#slide3">
                            <img width="67" alt=""  src="resources/assets/images/products/${iphone.photo3}" data-echo="resources/assets/images/products/${iphone.photo3}"  />
                        </a>
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
        <div class="no-margin col-xs-12 col-sm-7 body-holder">
            <div class="body">
                <div class="availability"><label>Availability:</label><span class="available">  in stock</span></div>
                <div class="title"><a href="#">${product.productId}</a></div>
                <div class="brand">{iphone.year}   </div>
                <div class="social-row">
                    <span class="st_facebook_hcount"></span>
                    <span class="st_twitter_hcount"></span>
                    <span class="st_pinterest_hcount"></span>
                </div>
                <div class="buttons-holder">
                    <a class="btn-add-to-wishlist" href="add-product-to-wish-list.htm?id=${iphone.id}">add to wishlist</a>
                    <a class="btn-add-to-compare" href="add-product-to-compare-list.htm?id=${iphone.id}">add to compare list</a>
                </div>
                <div class="excerpt">
                    <p>${product.machineDescription}</p>

                </div>

                <div class="prices">
                    <!--            <div class="price-current">$1740.00</div>
                                <div class="price-prev">$2199.00</div>-->
                </div>

                <div class="qnt-holder">
                    <!--            <div class="le-quantity">
                                    <form>
                                        <a class="minus" href="#reduce"></a>
                                        <input name="quantity" readonly="readonly" type="text" value="1" />
                                        <a class="plus" href="#add"></a>
                                    </form>
                                </div>-->
                    <a id="addto-cart" href="add-product-to-customer-basket.htm?id=${iphone.id}" class="le-button huge">add to cart</a>
                </div><!-- /.qnt-holder -->
            </div><!-- /.body -->

        </div><!-- /.body-holder -->
    </div><!-- /.container -->





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
                        <p>${product.machineDescription}</p>
                        <div class="meta-row">
                            <div class="inline">
                                <label>SKU:</label>
                                <span>54687621</span>
                            </div><!-- /.inline -->
                            <span class="seperator">/</span>
                            <div class="inline">
                                <label>categories:</label>
                                <!--<span><a href="#">-50% sale</a>,</span>-->
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
                    <div class="tab-pane" id="additional-info">
                        <ul class="tabled-data">
                            <li>
                                <label>Модель </label>
                                <div class="value">{iphone.model}</div>

                            </li>
                            <li>
                                <label>Производитель</label>
                                <div class="value">{iphone.manufacturer}</div>
                            </li>
                            <li>
                                <label>Год </label>
                                <div class="value">{iphone.year}</div>
                            </li>
                            <li>
                                <label>Тип</label>
                                <div class="value">{iphone.type}</div>
                            </li>
                            <li>
                                <label>Операционная система</label>
                                <div class="value">{iphone.os}</div>
                            </li>
                            <li>
                                <label>Размер экрана</label>
                                <div class="value">{iphone.display_size}</div>
                            </li>
                            <li>
                                <label>Разрешение экрана</label>
                                <div class="value">{iphone.display_resolution}</div>
                            </li>
                            <li>
                                <label>RAM память</label>
                                <div class="value">$iphone.ram_memory}</div> mm
                            </li>
                            <li>
                                <label>Flash память</label>
                                <div class="value">{iphone.flash_memory}</div>
                            </li>
                            <li>
                                <label>Несколько СИМ</label>
                                <div class="value">{iphone.sim_several}</div>
                            </li>
                            <li>
                                <label>Камера</label>
                                <div class="value">$iphone.camera}</div>
                            </li>
                            <li>
                                <label>Количество точек матрицы </label>
                                <div class="value">{iphone.matrix_points},  Мп</div>
                            </li>
                            <li>
                                <label>Конструкция корпуса </label>
                                <div class="value">$iphone.design_case}</div>
                            </li>

                            <li>
                                <label>Материал</label>
                                <div class="value">{iphone.material}</div>
                            </li>
                            <li>
                                <label>Цвет</label>
                                <div class="value">{iphone.color}</div>
                            </li>
                            <li>
                                <label>Формат SIM-карты  </label>
                                <div class="value">{iphone.sim_format}</div>
                            </li>
                            <li>
                                <label>Габориты</label>
                                <div class="value">{iphone.dimensions}</div>
                            </li>
                            <li>
                                <label>Вес  </label>
                                <div class="value">{iphone.weight}</div>
                            </li>

                            <li>
                                <label>Тип аккумулятора </label>
                                <div class="value">{iphone.battery_type}</div>
                            </li>
                            <li>
                                <label>Ёмкость аккумулятора</label>
                                <div class="value">{iphone.battery_capacity}  мА·ч</div>
                            </li>
                            <li>
                                <label>Несъёмный аккумулятор </label>
                                <div class="value">{iphone.battery_removable}</div>
                            </li>
                            <li>
                                <label>Время разговора</label>
                                <div class="value">{iphone.time_talk}, часов</div>
                            </li>
                            <li>
                                <label>Время ожидания (коректир)</label>
                                <div class="value">{iphone.time_out}</div>
                            </li>
                            <li>
                                <label>Описание</label>
                                <div class="value">{iphone.description}</div>
                            </li>
                        </ul>

                        <div class="meta-row">
                            <div class="inline">
                                <label>SKU:</label>
                                <span>54687621</span>
                            </div>
                            <span class="seperator">/</span>
                            <div class="inline">
                                <label>categories:</label>
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

                </div><!-- /.tab-content -->

            </div><!-- /.tab-holder -->
        </div><!-- /.container -->
    </section><!-- /#single-product-tab -->

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

<!-- For demo purposes â can be removed on production -->

<script src="resources/assets/switchstylesheet/switchstylesheet.js"></script>

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
<!-- For demo purposes â can be removed on production : End -->

<script src="http://w.sharethis.com/button/buttons.js"></script>

</body>
</html>