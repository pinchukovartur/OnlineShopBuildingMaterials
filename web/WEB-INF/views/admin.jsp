<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <%--lib--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--/lib--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css"/>
    <title>Admin</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Строительный магазин</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin-left: 16%">
            <ul class="nav navbar-nav">
                <li><a href="/">Каталог</a></li>
                <li><a href="/">Корзина</a></li>
                <li class="active"><a href="/admin">Личный кабинет</a></li>
            </ul>
        </div>
    </div>
</nav>

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

<button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#addModal">Добавить</button>
<div id="addModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Добавление товара</h4>
            </div>
            <div class="modal-body">
                <spring:form method="POST" modelAttribute="addProduct" action="newProduct">
                    ProductID: <spring:input path="productId"/><br/>
                    Type: <spring:input path="type"/><br/>
                    Length: <spring:input path="length"/><br/>
                    Weight: <spring:input path="weight"/><br/>
                    Thickness: <spring:input path="thickness"/><br/>
                    Grade: <spring:input path="grade"/><br/>
                    Price: <spring:input path="price"/><br/>
                    Sanded: <spring:input path="sanded"/><br/>
                    WaterResistance: <spring:input path="waterResistance"/><br/>
                    NumberOfSheets: <spring:input path="numberOfSheets"/><br/>
                    NumberOfPackages: <spring:input path="numberOfPackages"/><br/>
                    MachineDescription: <spring:input path="machineDescription"/><br/>
                    Сolor: <spring:input path="color"/><br/>
                    <spring:button>Добавить</spring:button>
                </spring:form>
            </div>
            <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
        </div>
    </div>
</div>

<button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#delModal">Удалить</button>
<div id="delModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Удаление товара</h4>
            </div>
            <div class="modal-body">
                <form action ="dProduct" method="post">
                    ID: <input type="text" name="idProduct" style="width:50px" min="1" max="100" REQUIRED>
                    <input type="submit" name="idProduct" value="Delete by ID">
                </form>
            </div>
            <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
        </div>
    </div>
</div>

<table class="simple-little-table" border="3">
    <caption>User</caption>
    <tr>
        <th>username</th>
        <th>password</th>
        <th>email</th>
        <th>role</th>
    </tr>
    <%--@elvariable id="listUsers" type="java.util.List"--%>
    <c:forEach var="elem" items="${listUsers}" varStatus="status">
        <tr>
            <td><c:out value="${ elem.username }"/></td>
            <td><c:out value="${ elem.password }"/></td>
            <td><c:out value="${ elem.email }"/></td>
            <td><c:out value="${ elem.role }"/></td>
        </tr>
    </c:forEach>
</table>

<spring:form method="POST" action="uploadFile" enctype="multipart/form-data">
     <input type="file" name="file"/>
     <input type="text" name="fileName"/>
     <input type="submit" value="Upload">
</spring:form>
</body>
</html>
