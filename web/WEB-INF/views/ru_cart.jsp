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

        <!-- Icons/Glyphs -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">
        
        <!-- Favicon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/images/favicon.ico">

    </head>
    
    
    
    
<body>

    
    <div class="wrapper">
        <!-- ============================================================= TOP NAVIGATION ============================================================= -->

  <%@include file="includes/nav.jsp" %>
        
<!-- ============================================================= TOP NAVIGATION : END ============================================================= -->       <!-- ============================================================= HEADER ============================================================= -->

<%@include file="includes/header.jsp" %>
<!-- ============================================================= HEADER : END ============================================================= --><div class="animate-dropdown"><!-- ========================================= BREADCRUMB ========================================= -->

    <div id="top-mega-nav">
    <div class="container">
        <nav>
            <ul class="inline">
                <li class="breadcrumb-nav-holder"> 
                    <ul>
                        <li class="breadcrumb-item">
                            <a href="index.htm">Главная</a>
                        </li>
                        <li class="breadcrumb-item current gray">
                            <a href="#">Корзина</a>
                        </li>
                    </ul>
                </li><!-- /.breadcrumb-nav-holder -->
            </ul>
        </nav>
    </div><!-- /.container -->
</div><!-- /#top-mega-nav -->
</div>     <section id="cart-page">
    <div class="container">
        <!-- ========================================= CONTENT ========================================= -->
        <div class="col-xs-12 col-md-9 items-holder no-margin">
<!--         
-->       <c:forEach var="item" items="${basketList}">
            <div class="row no-margin cart-item">
                <div class="col-xs-12 col-sm-2 no-margin">
                    <a href="vmc${item.productId}.htm" class="thumb-holder">

                        <img class="lazy" alt="" width="73" height="73" src="resources/initialData/jpg/${item.materialsPicturesList[0].photo}.jpg"/>
                    </a>
                </div>

                <div class="col-xs-12 col-sm-5 ">
                    <div class="title">
                        <a href="#">${item.productId}</a>
                    </div>
                    <div class="brand">${item.price}</div>
                </div> 

                <div class="col-xs-12 col-sm-3 no-margin">
                    <div class="quantity">
                        <div class="le-quantity">
                              <form>
                                <input name="quantity" readonly="readonly" type="text"  value="1" /> </input>
                            </form>
                        </div>
                    </div>
                </div>


                <div class="col-xs-12 col-sm-2 no-margin">
                    <div class="price">
                        ${item.price}<br>
                            <input type="checkbox"/>
                            <a href="/buymaterial/${elem.productId}">Заказать товар</a>
                    </div>
                    <a class="close-btn" href="deleteBasketProduct/${item.productId}"></a>
                </div>
            </div>
         </c:forEach>
        </div>

        <div class="col-xs-12 col-md-3 no-margin sidebar ">
            <div class="widget cart-summary">
                <h1 class="border">shopping cart</h1>
                <div class="body">
                    <ul class="tabled-data no-border inverse-bold">
                        <li>
                            <label>cart subtotal</label>
                            <div class="value pull-right">{cart.subtotal}</div>
                        </li>
                        <li>
                            <label>VAT</label>
                            <div class="value pull-right">not included</div>
                        </li>
                        <li>
                            <label>shipping</label>
                            <div class="value pull-right">not included</div>
                        </li>
                    </ul>
                    <ul id="total-price" class="tabled-data inverse-bold no-border">
                        <li>
                            <label>order total</label>
                            <div class="value pull-right">{cart.total}</div>
                        </li>
                    </ul>
                    <div class="buttons-holder">
                        <!--<a class="le-button big" href="#" >checkout</a>-->
                        <a class="simple-link block" href="index.htm" >continue shopping</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>      
                        
                        
                
                        
                        


<%@include file="includes/footer.jsp" %>

    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-migrate-1.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/gmap3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/css_browser_selector.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/echo.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.easing-1.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-slider.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.raty.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.prettyPhoto.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.customSelect.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/scripts.js"></script>

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

    <script src="http://w.sharethis.com/button/buttons.js"></script>

</body>
</html>