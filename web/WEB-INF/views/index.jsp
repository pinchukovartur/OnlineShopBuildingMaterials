<%@ page import="ru.pinch.service.ApplicationMailer" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>

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
    <div class="lang_div">
        <a class="lang_button" href="?lang=en">en</a>
        <a class="lang_button" href="?lang=ru">ru</a>
    </div>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" style="margin-left: 12%">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><local:message code="label.hardwareStore"/></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="margin-left: 16%;">
                    <li class="active"><a href="/"><local:message code="label.catalog"/></a></li>
                    <li><a href="/basket"><local:message code="label.basket"/></a></li>
                    <li><a href="/cabinet"><local:message code="label.personalArea"/></a></li>
                    <li><a href="/j_spring_security_logout"><local:message code="label.exit"/></a></li>
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
    <div class="row">
        <div class="container">
            <div class="col-md-2">
                <div class="">
                    <button>wwdawd</button><br>
                    <button>wwdawd</button><br>
                    <button>wwdawd</button><br>
                    <button>wwdawd</button><br>
                    <button>wwdawd</button><br>
                    <button>wwdawd</button>
                </div>
            </div>
            <div class=" col-md-6">
                <div class="catalog">
                    <c:forEach var="x" items="${listProduct}" varStatus="status">
                        <div class="item">
<%--
                            <img src="${pageContext.request.contextPath}/resources/images/${x.materialsPictures[0].photo}.png" class="images">
--%>
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