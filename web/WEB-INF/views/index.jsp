<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css"/>


    <title>Index Page</title>
</head>
<body>
    <a href="/admin">перейти на админа</a>


    <table border="0">
        <c:forEach var="x" items="${listProduct}" varStatus="status">
            <tr>
                <td>
                    <img src="/resources/images/plywood%201.jpg" class="images">
                    <c:out value="${x.productId }"/>
                    <c:out value="${x.type }"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>