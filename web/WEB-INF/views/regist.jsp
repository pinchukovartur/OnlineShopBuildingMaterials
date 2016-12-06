<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>

    <link href="<c:url value="/resources/css/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>
<div class="container" style="width: 300px;">
        <c:if test="${not empty error}">
            ${error}
        </c:if>
        <spring:form method="post" modelAttribute="user" action="/registration">
            Name: <spring:input class="form-control" path="username"/><br>
            Email: <spring:input class="form-control" path="email"/><br>
            Password: <spring:input class="form-control"  path="password"/><br>
            <spring:button class="btn btn-lg btn-primary btn-block">Зарегестрироваться</spring:button>
        </spring:form>
</div>
</body>
</html>
