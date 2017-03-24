<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/static/public/css/default.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/static/public/css/blue.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/static/public/css/datePicker.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/static/public/css/wysiwyg.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/static/public/css/fancybox-1.3.1.css"/>" rel="stylesheet" type="text/css"
          media="screen"/>
    <link href="<c:url value="/static/public/css/visualize.css"/>" rel="stylesheet" type="text/css" media="screen"/>

    <%--lib--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--/lib--%>

    <script type="text/javascript" src="<c:url value="/static/mystyles/js/adminAccordionMenu.js"/>"></script>
    <link href="<c:url value="/static/mystyles/css/adminAccordionMenu.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <a href="/" title="Go to Homepage"><span>Great Admin</span></a>
        </div>
        <div id="user">
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
                    <span>Product Table</span>
                </h2>
            </div>
            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Main Photo</th>
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${product.idProduct }"/></td>
                            <td><c:out value="${product.productName }"/></td>
                            <td><c:out value="${product.price }"/></td>
                            <td><c:out value="${product.description }"/></td>
                            <td><c:out value="${product.category.categoryName}"/></td>
                            <td>
                                <c:forEach items="${product.photos}" var="photo" begin="0" end="0">
                                     <c:out value="${photo.photoName}"/>
                                </c:forEach>
                            </td>
                            <td class="action"><a href="dProduct?productId=${product.idProduct}"
                                                  class="ico ico-delete">Delete</a>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="box">
            <div class="headlines">
                <h2>
                    <span>Загрузка данных</span>
                </h2>
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
                        <label>Id продукта:</label>
                        <input type="text" name="productId"/>
                        <div class="tab-action">
                            <input type="submit" value="Загрузить" class="button"
                                   id="upload"/>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <div id="sidebar">
        <div id='cssmenu'>
            <ul>
                <li class='active'><a href='/'><span>Main</span></a></li>
                <li class='has-sub'><a href='#'><span>Create new product</span></a>
                    <c:forEach items="${catalogs}" var="catalog">
                    <ul>
                        <li class='has-sub'><a href='#'><span>${catalog.catalogName}</span></a>
                            <ul>
                                <c:forEach items="${catalog.categoryList}" var="category">
                                <li><a href='/addNewProduct?categoryId=${category.idCategory}'><span>${category.categoryName}</span></a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    </c:forEach>
                </li>
            </ul>
        </div>
    </div>
    <div id="footer">
        <p>
            © 2017 Great Admin
        </p>
    </div>
</div>
</body>
</html>

