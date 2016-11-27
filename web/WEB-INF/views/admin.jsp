<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value ="/resources/css/authorization.css" />" rel="stylesheet">
    <title>Admin</title>
</head>
<body>
    <form class="box login">
        <fieldset class="boxBady">
            <label>Username</label>
            <input type="text" tabindex="1" placeholder="PremiumPixel" required>
            <label><a href="#" class="rLink" tabindex="5">Forget your password?</a></label>
            <input type="password" tabindex="2" required>
        </fieldset>
        <footer>
            <label><input type="checkbox" tabindex="3">Keep me logget in</label>
            <input type="submit" class="btnLogin" value="Login" tabindex="4">
        </footer>
    </form>
</body>
</html>
