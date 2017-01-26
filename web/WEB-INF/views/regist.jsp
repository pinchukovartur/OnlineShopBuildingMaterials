<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name='robots' content='all, follow'/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title><local:message code="login.label.signIn"/></title>
    <link href="${pageContext.request.contextPath}/resources/public/css/login.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/public/css/login-blue.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div id="main">
    <div id="content">
        <div id="login">
            <div id="logo"></div>
            <form method="post" action="${pageContext.request.contextPath}/registration" id="form-login"
                  class="formBox">
                <fieldset>
                    <ul>
                        <c:if test="${not empty error}">
                            <label for="username" class="lab">${error}<span
                                    class="warning"></span></label>
                        </c:if>

                        <li>
                            <div class="form-col">
                                <label for="username" class="lab"><local:message code="login.label.userName"/><span
                                        class="warning"></span></label>
                                <input type="text" class="input" id="username" name="username"/>
                            </div>
                        </li>
                        <li>
                            <div class="form-col form-col-right">
                                <label for="password" class="lab"><local:message code="login.label.password"/><span
                                        class="warning"></span></label>
                                <input type="password" class="input" id="password" name="password"/>
                            </div>
                        </li>
                        <li>
                            <div class="form-col form-col-right">
                                <label for="password" class="lab">email<span
                                        class="warning"></span></label>
                                <input type="text" class="input" id="email" name="email"/>
                            </div>
                        </li>
                    </ul>
                </fieldset>
                <div class="form-col form-col-right">
                    <input type="submit" name="" value="Login" class="submit"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
</body>
</html>

