<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local"%>


<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
    <%--lib--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.css">
    <%--/lib--%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css"/>
    <title>Index Page</title>
</head>
<body>

<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="margin-left: 12%">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Строительный Магазин<%--<local:message code="label.ha"--%></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="margin-left: 16%;">
                <li class="active"><a href="/">Каталог</a></li>
                <li><a href="/">Корзина</a></li>
                <li><a href="/admin">Личный кабинет</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</nav>

<div class="container">
        <h1>Каталог</h1>
        <div class="catalog">
            <c:forEach var="x" items="${listProduct}" varStatus="status">
            <div class="item">
                <img src="/resources/images/plywood%201.jpg" class="images">
                <c:out value="${x.productId }"/>
                <c:out value="${x.price }"/>$
                <local:message code="label.basket"/>
            </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>