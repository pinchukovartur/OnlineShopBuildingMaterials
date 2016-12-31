<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="local" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
<table class="simple-little-table" border="3">
    <caption>PRODUCTS</caption>
    <tr>
        <th><local:message code="label.productId"/></th>
        <th><local:message code="label.type"/></th>
        <th><local:message code="label.length"/></th>
        <th><local:message code="label.weight"/></th>
        <th><local:message code="label.thickness"/></th>
        <th><local:message code="label.color"/></th>
        <th><local:message code="label.grade"/></th>
        <th><local:message code="label.sanded"/></th>
        <th><local:message code="label.waterResistance"/></th>
        <th><local:message code="label.price"/></th>
        <th><local:message code="label.numberOfSheets"/></th>
        <th><local:message code="label.numberOfPackages"/></th>
        <th><local:message code="label.machineDescription"/></th>
    </tr>
    <%--@elvariable id="basketList" type="java.util.List"--%>
    <c:forEach var="elem" items="${basketList}" varStatus="status">
        <tr>
            <td><c:out value="${ elem.productId }"/></td>
            <td><c:out value="${ elem.type }"/></td>
            <td><c:out value="${ elem.length }"/></td>
            <td><c:out value="${ elem.weight }"/></td>
            <td><c:out value="${ elem.thickness }"/></td>
            <td><c:out value="${ elem.color }"/></td>
            <td><c:out value="${ elem.grade }"/></td>
            <td><c:out value="${ elem.sanded }"/></td>
            <td><c:out value="${ elem.waterResistance }"/></td>
            <td><c:out value="${ elem.price }"/></td>
            <td><c:out value="${ elem.numberOfSheets }"/></td>
            <td><c:out value="${ elem.numberOfPackages }"/></td>
            <td><c:out value="${ elem.machineDescription }"/></td>
            <td><a href="/buymaterial/${elem.productId}">Заказать товар</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
