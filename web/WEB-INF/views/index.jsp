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
    <meta name="keywords" content="Laser, VMC , HMC">
    <meta name="robots" content="all">

    <title>PMarket</title>

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
    <link rel="shortcut icon" href="resources/assets/images/eftech.ico">
    <script src="resources/assets/js/html5shiv.js"></script>
    <script src="resources/assets/js/respond.min.js"></script>
</head>
<body>

<div class="wrapper">

    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/header.jsp" %>

    <div class="container">

        <div class="col-xs-12 col-sm-4 col-md-3 sidemenu-holder">
            <div class="side-menu animate-dropdown">
                <div class="head"><i class="fa fa-list"></i>Разделы</div>
                <nav class="yamm megamenu-horizontal" role="navigation">
                    <ul class="nav">
                        <li><a href="/page_1">Станки</a></li>
<%--
                        <li><a href="#">Еще что нить</a></li>
--%>
                    </ul>
                </nav>
            </div>
        </div>

        <div class="col-xs-12 col-sm-8 col-md-9 homebanner-holder">
            <div id="hero">
                <div id="owl-main" class="owl-carousel owl-inner-nav owl-ui-sm">
                    <div class="item" style="background-image: url(/resources/initialData/jpg/dsp.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big"><span class="sign"></span></span>DSP
                                </div>
                                <div class="excerpt fadeInDown-2">
                                    <%--<br>DMC 80 FD<br>--%>
                                </div>
                                <div class="small fadeInDown-2">
                                    <%--RU--%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item" style="background-image: url(/resources/initialData/jpg/particleboard.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big"><span class="sign"></span> </span>DSP
                                </div>

                                <div class="excerpt fadeInDown-2">
                                    <%--<br>DMC 55<br>--%>
                                </div>
                                <div class="small fadeInDown-2">
                                    <%--BY--%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item" style="background-image: url(/resources/initialData/jpg/plywood1.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big"><span class="sign"></span></span>FANERA
                                </div>

                                <div class="excerpt fadeInDown-2">
                                    <%--<br>CTX 1250 TC<br>--%>
                                </div>
                                <div class="small fadeInDown-2">
                                    <%--CH--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

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