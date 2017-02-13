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
                    <span>Plywood Table</span>
                </h2>
            </div>
            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
                        <th>Product Name</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Weight</th>
                        <th>Length</th>
                        <th>Thickness</th>
                        <th>Grade</th>
                        <th>Sanded</th>
                        <th>WaterResistance</th>
                        <th>NumberOfSheets</th>
                        <th>NumberOfPackages</th>
                        <th>Description</th>
                        <th>Main Photo</th>
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${plywoodList}" var="plywood">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${plywood.productId }"/></td>
                            <td><c:out value="${plywood.type }"/></td>
                            <td><c:out value="${plywood.price }"/></td>
                            <td><c:out value="${plywood.weight }"/></td>
                            <td><c:out value="${plywood.length}"/></td>
                            <td><c:out value="${plywood.thickness}"/></td>
                            <td><c:out value="${plywood.grade}"/></td>
                            <td><c:out value="${plywood.sanded}"/></td>
                            <td><c:out value="${plywood.waterResistance}"/></td>
                            <td><c:out value="${plywood.numberOfSheets}"/></td>
                            <td><c:out value="${plywood.numberOfPackages}"/></td>
                            <td><c:out value="${plywood.description}"/></td>
                            <td><c:out value="${plywood.photoList[0].photo}"/></td>
                            <td class="action"><a href="dProduct/${plywood.productId}"
                                                  class="ico ico-delete">Delete</a>
                        </tr>
                    </c:forEach>
                    <tr>
                        <form action="addPlywood" METHOD="get">
                            <td class="dragHandle">&nbsp;</td>
                            <td><input name="productId" SIZE="5"></td>
                            <td><label>Plywood</label></td>
                            <td><input name="price" SIZE="3"></td>
                            <td><input name="weight" SIZE="5"></td>
                            <td><input name="length" SIZE="5"></td>
                            <td><input name="thickness" SIZE="5"></td>
                            <td><input name="grade" SIZE="1"></td>
                            <td><input name="sanded" SIZE="1"></td>
                            <td><input name="waterResistance" SIZE="1"></td>
                            <td><input name="numberOfSheets" SIZE="5"></td>
                            <td><input name="numberOfPackages" SIZE="5"></td>
                            <td><input name="description" SIZE="5"></td>
                            <td><label>DEFAULT NULL</label></td>
                            <td class="action">
                                <input type="submit"/>
                            </td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>


        <div class="box">
            <div class="headlines">
                <h2>
                    <span>Particle Board Table</span>
                </h2>
            </div>
            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
                        <th>Product Name</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Weight</th>
                        <th>Length</th>
                        <th>Thickness</th>
                        <th>NumberOfSheets</th>
                        <th>NumberOfPackages</th>
                        <th>Color</th>
                        <th>Description</th>
                        <th>Main Photo</th>
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${particleBoardsList}" var="particleBoard">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${particleBoard.productId }"/></td>
                            <td><c:out value="${particleBoard.type }"/></td>
                            <td><c:out value="${particleBoard.price }"/></td>
                            <td><c:out value="${particleBoard.weight }"/></td>
                            <td><c:out value="${particleBoard.length }"/></td>
                            <td><c:out value="${particleBoard.thickness }"/></td>
                            <td><c:out value="${particleBoard.numberOfSheets }"/></td>
                            <td><c:out value="${particleBoard.numberOfPackages }"/></td>
                            <td><c:out value="${particleBoard.color }"/></td>
                            <td><c:out value="${particleBoard.description }"/></td>
                            <td><c:out value="${particleBoard.photoList[0].photo}"/></td>
                            <td class="action"><a href="dProduct/${particleBoard.productId}"
                                                  class="ico ico-delete">Delete</a>
                        </tr>
                    </c:forEach>
                    <tr>
                        <form action="addParticleBoard" METHOD="get">
                        <td class="dragHandle">&nbsp;</td>
                        <td><input name="productId" SIZE="5"></td>
                        <td><label>ParticleBoard</label></td>
                        <td><input name="price" SIZE="3"></td>
                        <td><input name="weight" SIZE="5"></td>
                        <td><input name="length" SIZE="5"></td>
                        <td><input name="thickness" SIZE="5"></td>
                        <td><input name="numberOfSheets" SIZE="5"></td>
                        <td><input name="numberOfPackages" SIZE="5"></td>
                        <td><input name="color" SIZE="5"></td>
                        <td><input name="description" SIZE="5"></td>
                        <td><label>DEFAULT NULL</label></td>
                        <td class="action">
                            <input type="submit"/>
                        </td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>

        <div class="box">
            <div class="headlines">
                <h2>
                    <span>Robot Table</span>
                </h2>
            </div>
            <div class="box-content">
                <table class="tab tab-drag">
                    <tr class="top nodrop nodrag">
                        <td class="dragHandle">&nbsp;</td>
                        <th>Product Name</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Weight</th>
                        <th>Model</th>
                        <th>Manufacturer</th>
                        <th>ProductionYear</th>
                        <th>Condition</th>
                        <th>Axles</th>
                        <th>MaxLoad</th>
                        <th>Reach</th>
                        <th>Footprint</th>
                        <th>Repeatability</th>
                        <th>Description</th>
                        <th>Main Photo</th>
                        <th class="action">Action</th>
                    </tr>
                    <c:forEach items="${robotList}" var="particleBoard">
                        <tr>
                            <td class="dragHandle">&nbsp;</td>
                            <td><c:out value="${particleBoard.productId }"/></td>
                            <td><c:out value="${particleBoard.type }"/></td>
                            <td><c:out value="${particleBoard.price }"/></td>
                            <td><c:out value="${particleBoard.weight }"/></td>
                            <td><c:out value="${particleBoard.model }"/></td>
                            <td><c:out value="${particleBoard.manufacturer }"/></td>
                            <td><c:out value="${particleBoard.productionYear }"/></td>
                            <td><c:out value="${particleBoard.condition }"/></td>
                            <td><c:out value="${particleBoard.axles }"/></td>
                            <td><c:out value="${particleBoard.maxLoad }"/></td>
                            <td><c:out value="${particleBoard.reach }"/></td>
                            <td><c:out value="${particleBoard.footprint }"/></td>
                            <td><c:out value="${particleBoard.repeatability }"/></td>
                            <td><c:out value="${particleBoard.description }"/></td>
                            <td><c:out value="${particleBoard.photoList[0].photo}"/></td>
                            <td class="action"><a href="dProduct/${particleBoard.productId}"
                                                  class="ico ico-delete">Delete</a>
                        </tr>
                    </c:forEach>
                    <tr>
                        <form action="addRobot" METHOD="get">
                            <td class="dragHandle">&nbsp;</td>
                            <td><input name="productId" SIZE="5"></td>
                            <td><label>Robot</label></td>
                            <td><input name="price" SIZE="3"></td>
                            <td><input name="weight" SIZE="5"></td>
                            <td><input name="model" SIZE="5"></td>
                            <td><input name="manufacturer" SIZE="5"></td>
                            <td><input name="productionYear" SIZE="5"></td>
                            <td><input name="condition" SIZE="5"></td>
                            <td><input name="axles" SIZE="5"></td>
                            <td><input name="maxLoad" SIZE="5"></td>
                            <td><input name="reach" SIZE="5"></td>
                            <td><input name="footprint" SIZE="5"></td>
                            <td><input name="repeatability" SIZE="5"></td>
                            <td><input name="description" SIZE="5"></td>
                            <td><label>DEFAULT NULL</label></td>
                            <td class="action">
                                <input type="submit"/>
                            </td>
                        </form>
                    </tr>
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