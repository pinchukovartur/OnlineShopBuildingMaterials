<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Index Page</title>
</head>
<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

    Name: <spring:input path="productId"/> (path="" - указывает путь, используемый в modelAttribute=''. в нашем случае User.name)  <br/>
    Password: <spring:input path="type"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>
</body>

</html>