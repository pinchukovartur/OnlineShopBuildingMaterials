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

        <link rel="stylesheet" href="<c:url value="/static/assets/css/font-awesome.min.css"/>">

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
                        <li class="breadcrumb-item current gray">
                            <a href="#">Корзина</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
</div>     <section id="cart-page">
    <div class="container">
        <div class="col-xs-12 col-md-9 items-holder no-margin">
       <c:forEach var="item" items="${basketList}">
            <div class="row no-margin cart-item">
                <div class="col-xs-12 col-sm-2 no-margin">
                    <a href="vmc${item.idProduct}.htm" class="thumb-holder">
                        <c:forEach items="${item.photos}" begin="0" end="0" var="photo">
                        <img class="lazy" alt="" width="73" height="73" src="/media/${photo.photoName}"/>
                        </c:forEach>
                    </a>
                </div>

                <div class="col-xs-12 col-sm-3 ">
                    <div class="title">
                        <a href="/product&id=${item.idProduct}">${item.productName}</a>
                    </div>
                    <div class="brand">${item.description}</div>
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
                            <%--<input type="checkbox"/>--%>
                            <a href="/buy?productID=${item.idProduct}">Заказать товар</a><br>
                            <a href="/getPDF?id=${item.idProduct}">Скачать pdf</a>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-2 no-margin">
                    <a class="close-btn" href="/deleteBasketProduct?idProduct=${item.idProduct}"></a>
                </div>
            </div>
         </c:forEach>
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