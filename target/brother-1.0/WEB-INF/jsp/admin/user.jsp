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
                    <span>Users Table</span>
                </h2>
            </div>

            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Enabled</th>
                        <th>Role</th>
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${usersList}" var="elem">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${elem.username }"/></td>
                            <td><c:out value="${elem.email }"/></td>
                            <td><c:out value="${elem.password }"/></td>
                            <td><c:out value="${elem.enabled }"/></td>
                            <td><c:out value="${elem.role.authority}"/></td>
                            <td class="action"><a href="dUser/${elem.username}"
                                                  class="ico ico-delete">Delete</a>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div id="sidebar">
        <ul id="floatMenu" class="mainmenu">
            <li><a href="/admin?window=purchases" title="Purchases Menu" class="link">Purchases Menu</a></li>
            <li><a href="/admin?window=users" title="Users Menu" class="link">Users Menu</a></li>
            <li><a href="/admin?window=products" title="Products Menu" class="link">Products Menu</a></li>
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