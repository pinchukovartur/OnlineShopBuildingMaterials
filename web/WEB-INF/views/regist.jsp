<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</html>--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name='robots' content='all, follow'/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title><local:message code="login.label.signIn"/></title>
    <link href="${pageContext.request.contextPath}/resources/public/css/login.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/public/css/login-blue.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div id="main">
    <div id="content">
        <div id="login">
            <div id="logo"></div>
            <form method="post" action="${pageContext.request.contextPath}/registration" id="form-login"
                  class="formBox">
                <fieldset>
                    <c:if test="${not empty error}">
                        ${error}
                    </c:if>
                    <div class="form-col">
                        <label for="username" class="lab"><local:message code="login.label.userName"/><span
                                class="warning"></span></label>
                        <input type="text" class="input" id="username" name="username"/>
                    </div><br>
                    <div class="form-col form-col-right">
                        <label for="password" class="lab"><local:message code="login.label.password"/><span
                                class="warning"></span></label>
                        <input type="password" class="input" id="password" name="password"/>
                    </div><br>
                    <div class="form-col form-col-right">
                        <label for="password" class="lab">email<span
                                class="warning"></span></label>
                        <input type="password" class="input" id="email" name="email"/>
                    </div>
                    <div class="form-col form-col-right">
                        <input type="submit" name="" value="Login" class="submit"/>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
</div>
</body>
</html>
</body>
</html>

