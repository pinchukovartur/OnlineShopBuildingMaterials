<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Index Page</title>
</head>
<body>
${listProduct.get(1).getProductId()}
<table border="1">
    <caption>TABLE PRODUCTS</caption>
    <tr>
        <th>productId</th>
        <th>type</th>
        <th>length</th>
        <th>weight</th>
        <th>thickness</th>
    </tr>
    <c:forEach var="elem" items="${listProduct}" varStatus="status">
    <tr>
        <td><c:out value="${ elem.productId }" /></td>
        <td><c:out value="${ elem.type }" /></td>
        <td><c:out value="${ elem.length }" /></td>
        <td><c:out value="${ elem.weight }" /></td>
        <td><c:out value="${ elem.thickness }" /></td>
    </tr>
    </c:forEach>
</table>
</body>

</html>