<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add page</title>

    <%--libs--%>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

    <link href="<c:url value='/static/mystyles/css/login.css' />" rel="stylesheet">

</head>

<body>
<div id="mainWrapper">
    <div class="login-container">
        <div class="login-card">
            <div class="login-form">
                <form:form method="post" modelAttribute="productInputForm">
                    <c:forEach items="${productInputForm.product}" var="item">
                        <label>${item.key}</label>
                        <input type="text" name="product['${item.key}']" value="${item.value}">
                        <br>
                    </c:forEach>
                    <input type="hidden" name="idCategory" value="${productInputForm.idCategory}">
                    <input type="submit" value="Отправить">
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
