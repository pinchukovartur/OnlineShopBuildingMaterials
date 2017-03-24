<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="local" uri="http://www.springframework.org/tags" %>

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

    <link rel="stylesheet" href="<c:url value="/static/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/green.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/owl.carousel.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/owl.transitions.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/animate.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/config.css"/>">
    <link href="<c:url value="/static/assets/css/green.css"/>" rel="alternate stylesheet" title="Green color">
    <link href="<c:url value="/static/assets/css/blue.css"/>" rel="alternate stylesheet" title="Blue color">
    <link href="<c:url value="/static/assets/css/red.css"/>" rel="alternate stylesheet" title="Red color">
    <link href="<c:url value="/static/assets/css/orange.css"/>" rel="alternate stylesheet" title="Orange color">
    <link href="<c:url value="/static/assets/css/navy.css"/>" rel="alternate stylesheet" title="Navy color">
    <link href="<c:url value="/static/assets/css/dark-green.css"/>" rel="alternate stylesheet" title="Darkgreen color">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/font-awesome.min.css"/>">
    <link rel="shortcut icon" href="<c:url value="/static/assets/images/eftech.ico"/>">
    <script src="<c:url value="/static/assets/js/html5shiv.js"/>"></script>
    <script src="<c:url value="/static/assets/js/respond.min.js"/>"></script>

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

    <link rel="stylesheet" href="<c:url value="/static/mystyles/css/accordion.css"/>">
    <script src="<c:url value="/static/mystyles/js/accordion.js"/>"></script>
</head>
<body>

<div class="wrapper">
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/header.jsp" %>

    <div class="container">
        <div class="col-xs-12 col-sm-4 col-md-3 sidemenu-holder">
            <div class="side-menu animate-dropdown">
                <ul id="accordion" class="head accordion">
                    <li>
                        <c:forEach items="${Catalogs}" var="i">
                            <div class="link"><i class="fa fa-database"></i>${i.catalogName}<i
                                    class="fa fa-chevron-down"></i></div>
                            <ul class="submenu">
                                <c:forEach items="${i.categoryList}" var="j">
                                    <li><a href="/catalog?id=${j.idCategory}&pageNumber=1">${j.categoryName}</a></li>
                                </c:forEach>
                            </ul>
                        </c:forEach>
                    </li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-8 col-md-9 homebanner-holder">
            <div id="hero">
                <div id="owl-main" class="owl-carousel owl-inner-nav owl-ui-sm">
                    <div class="item" style="background-image: url(/static/initialData/jpg/dsp.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big">
                                        <span class="sign">
                                            <local:message code="index.label.particleBoard"/>
                                        </span>
                                    </span>
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
                    <div class="item" style="background-image: url(/static/initialData/jpg/particleboard.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big">
                                        <span class="sign">
                                            <local:message code="index.label.particleBoard"/>
                                        </span>
                                    </span>
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
                    <div class="item" style="background-image: url(/static/initialData/jpg/plywood1.jpg);">
                        <div class="container-fluid">
                            <div class="caption vertical-center text-left">
                                <div class="big-text fadeInDown-1">
                                    <span class="big">
                                        <span class="sign">
                                            <local:message code="index.label.plywood"/>
                                        </span>
                                    </span>
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
        </div>
    </div>
</div>
</body>
</html>