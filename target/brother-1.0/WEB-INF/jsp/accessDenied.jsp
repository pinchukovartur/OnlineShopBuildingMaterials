<%@ taglib prefix="local" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><local:message code="label.accessDenied"/></title>
</head>
<body>
    <h2>
     ${errorMsg}
    </h2>
</body>
</html>
