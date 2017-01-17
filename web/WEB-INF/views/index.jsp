<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>

<html>
<head>
    <%--------------------------------------------------LIBRARIES-----------------------------------------------------%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.css">
    <%----------------------------------------------------------------------------------------------------------------%>

    <%--------------------------------------------------STYLES--------------------------------------------------------%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index/NAVBAR.css"/>
    <%----------------------------------------------------------------------------------------------------------------%>

    <title>EfTech</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ico/eftech.ico" type="image/x-icon">
</head>

<%------------------------------------------------------NAVBAR--------------------------------------------------------%>
<header>
    <div class="top_header">
        <p class="glyphicon glyphicon-envelope top_header_color margin_13">
        <spam class="contact_s"> EfTech@mail.ru</spam></p>
        <p class="glyphicon glyphicon-earphone top_header_color">
        <spam class="contact_s"> +12 345 67 89</spam></p>
        <p class="glyphicon glyphicon-cog top_header_color"></p>
        <a class="lng_btn" href="?lang=ru">ru</a>
        <a class="lng_btn" href="?lang=en">en</a>
    </div>

    <nav class="navbar navbar-default">
        <div class="container-fluid margin_13">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">
                    <local:message code="label.hardwareStore"/>
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="margin-left: 16%;">
                    <li class="active">
                        <a href="<c:url value="/"/>">
                            <local:message code="label.catalog"/>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/basket"/>">
                            <local:message code="label.basket"/>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/cabinet"/>">
                            <local:message code="label.personalArea"/>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/j_spring_security_logout"/>">
                            <local:message code="label.exit"/>
                        </a>
                    </li>
                </ul>
                <%--<form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>--%>
            </div>
        </div>
    </nav>
</header>
<%--------------------------------------------------------------------------------------------------------------------%>

<div class="row">
    <div class="container">
        <%--<div class="col-md-2">
            <div class="">
                <button>wwdawd</button>
                <br>
                <button>wwdawd</button>
                <br>
                <button>wwdawd</button>
                <br>
                <button>wwdawd</button>
                <br>
                <button>wwdawd</button>
                <br>
                <button>wwdawd</button>
            </div>
        </div>--%>
        <div class=" col-md-6">
            <div class="catalog">
                <c:forEach var="x" items="${listProduct}" varStatus="status">
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/images/${x.materialsPicturesList[0].photo}.png"
                             class="images">
                        <br>
                        <c:out value="${x.productId}"/>
                        <br>
                        <span style="color: orange"><c:out value="${x.price}"/> $</span>
                        <a href="/addtobasket/${x.productId}">Добавить в коорзину</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>