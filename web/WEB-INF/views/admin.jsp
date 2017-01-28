<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="local" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name='robots' content='all, follow'/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Great admin</title>
    <link
            href="${pageContext.request.contextPath}/resources/public/css/default.css"
            rel="stylesheet" type="text/css" media="screen"/>
    <link
            href="${pageContext.request.contextPath}/resources/public/css/blue.css"
            rel="stylesheet" type="text/css" media="screen"/>
    <!-- color skin: blue / red / green / dark -->
    <link
            href="${pageContext.request.contextPath}/resources/public/css/datePicker.css"
            rel="stylesheet" type="text/css" media="screen"/>
    <link
            href="${pageContext.request.contextPath}/resources/public/css/wysiwyg.css"
            rel="stylesheet" type="text/css" media="screen"/>
    <link
            href="${pageContext.request.contextPath}/resources/public/css/fancybox-1.3.1.css"
            rel="stylesheet" type="text/css" media="screen"/>
    <link
            href="${pageContext.request.contextPath}/resources/public/css/visualize.css"
            rel="stylesheet" type="text/css" media="screen"/>

    <%--lib--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--/lib--%>

</head>
<body>
<div id="main">

    <div id="header">
        <div id="logo">
            <a href="/" title="Go to Homepage"><span>Great Admin</span></a>
        </div>
        <div id="user">
            <h2><sec:authentication property="principal.username"/></h2>
            <a href="${pageContext.request.contextPath}/j_spring_security_logout">logout</a>
        </div>
    </div>

    <div id="content">
        <div class="breadcrumbs">
            <ul>
                <li class="home"><a href="/">Homepage</a></li>
                <li>Admin Page</li>
            </ul>
        </div>

        <div class="box">
            <div class="headlines">
                <h2>
                    <span>Загрузка данных</span>
                </h2>
                <%--<a href="#help" class="help"></a>--%>
            </div>
            <div class="box-content">
                <p>
                    <c:if test="${not empty errorImage}">
                        <label class="lab">${errorImage}</label>
                    </c:if>
                </p>
                <h2>Загрузка картинки товара</h2>
                <form class="formBox" method="post" action="uploadFile"
                      enctype="multipart/form-data">
                    <fieldset>

                        <div class="form">
                            <div class="col1">
                                <div class="clearfix file">
                                    <div class="con">
                                        <input type="file" class="upload-file" id="inputFile"
                                               name="file"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <label>Название продукта:</label>
                        <input type="text" name="material"/>
                        <div class="tab-action">
                            <input type="submit" value="Загрузить" class="button"
                                   id="upload"/>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="box-content">
                <p>
                    <c:if test="${not empty errorExcel}">
                        <label class="lab">${errorExcel}</label>
                    </c:if>
                </p>
                <h2>Загрузка из Excel</h2>
                <form class="formBox" method="post" action="uploadExcel"
                      enctype="multipart/form-data">
                    <fieldset>

                        <div class="form">
                            <div class="col1">
                                <div class="clearfix file">
                                    <div class="con">
                                        <input type="file" class="upload-file" name="file"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-action">
                            <input type="submit" value="Загрузить" class="button"/>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <div class="box">
            <div class="headlines">
                <h2>
                    <span>VMC or IR</span>
                </h2>
                <%--<a href="#help" class="help"></a>--%>
            </div>
            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
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
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${listProduct}" var="elem">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${elem.productId }"/></td>
                            <td><c:out value="${elem.type }"/></td>
                            <td><c:out value="${elem.length }"/></td>
                            <td><c:out value="${elem.weight }"/></td>
                            <td><c:out value="${elem.thickness }"/></td>
                            <td><c:out value="${elem.color }"/></td>
                            <td><c:out value="${elem.grade }"/></td>
                            <td><c:out value="${elem.sanded }"/></td>
                            <td><c:out value="${elem.waterResistance }"/></td>
                            <td><c:out value="${elem.price }"/></td>
                            <td><c:out value="${elem.numberOfSheets }"/></td>
                            <td><c:out value="${elem.numberOfPackages }"/></td>
                            <td><c:out value="${elem.machineDescription }"/></td>

                            <td class="action"><a href="dProduct/${elem.productId}"
                                                  class="ico ico-delete">Delete</a><%-- <a--%>
                                    <%--href="editAccumulator.htm?${mc.productId}"
                                    class="ico ico-edit">Edit</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>

                <div class="tab-action">
                    <a class="btn-default" data-toggle="modal" data-target="#addModal">
                        <span style="color: white;">
                            Добавить
                        </span></a>
                    <div id="addModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" type="button" data-dismiss="modal">×</button>
                                    <h4 class="modal-title">Добавление товара</h4>
                                </div>
                                <div class="modal-body row">
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
                                        <spring:button class="btn btn-info btn-lg">Добавить</spring:button>
                                    </spring:form>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<div id="sidebar">
    <ul id="floatMenu" class="mainmenu">
        <li><a href="/" title="Главная" class="link">Главная</a></li>
    </ul>
</div>
<div id="footer">
    <p>
        © 2017 Great Admin
    </p>
</div>
</div>
</body>
</html>