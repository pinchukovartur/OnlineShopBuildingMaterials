<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap/css/bootstrap.min.css">
    <script src="/resources/js/lib/jquery-3.1.1.js"></script>

    <script src="/resources/js/modal_window.js"></script>
    <link href="<c:url value ="/resources/css/admin.css" />" rel="stylesheet">

    <title>Admin</title>
</head>
<body>
<table class="simple-little-table" border="3">
    <caption>PRODUCTS</caption>
    <tr>
        <th>productId</th>
        <th>type</th>
        <th>length</th>
        <th>weight</th>
        <th>thickness</th>
        <th>color</th>
        <th>grade</th>
        <th>sanded</th>
        <th>waterResistance</th>
        <th>price</th>
        <th>numberOfSheets</th>
        <th>numberOfPackages</th>
        <th>machineDescription</th>
    </tr>
    <c:forEach var="elem" items="${listProduct}" varStatus="status">
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
        </tr>
    </c:forEach>
</table>
<div class="text-center">
    <a href="#" id="go" class="button7">Добавить</a>
    <a href="#" class="button7">Удалить</a>
    <a href="#" class="button7">Изменить</a>
</div>

<div id="modal_form">
    <span id="modal_close">X</span>
    <spring:form method="POST"  modelAttribute="addProduct" action="admin">
        ProductID: <spring:input path="productId"/><br/>
        Type: <spring:input path="type"/><br/>
      <%--  Length: <spring:input path="Length"/><br/>
        Weight: <spring:input path="Weight"/><br/>
        Thickness: <spring:input path="Thickness"/><br/>
        Grade: <spring:input path="Grade"/><br/>
        Price: <spring:input path="Price"/><br/>
        Sanded: <spring:input path="Sanded"/><br/>
        WaterResistance: <spring:input path="WaterResistance"/><br/>
        NumberOfSheets: <spring:input path="NumberOfSheets"/><br/>
        NumberOfPackages: <spring:input path="NumberOfPackages"/><br/>
        MachineDescription: <spring:input path="MachineDescription"/><br/>
        Сolor: <spring:input path="Сolor"/><br/>--%>
        <spring:button>Добавить</spring:button>
    </spring:form>
    </form>
</div>
<div id="overlay"></div>
</body>
</html>
