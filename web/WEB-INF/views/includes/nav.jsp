<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>

<nav class="top-bar animate-dropdown">
    <div class="container">
        <div class="col-xs-12 col-sm-6 no-margin">
            <ul>
                <li><a href="${pageContext.request.contextPath}/"><local:message code="nav.label.home"/></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#change-colors">
                        <local:message code="nav.label.changeColors"/>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li role="presentation"><a role="menuitem" class="changecolor green-text" tabindex="-1" href="#"
                                                   title="Green color">
                            <local:message code="nav.label.green"/></a>
                        </li>
                        <li role="presentation"><a role="menuitem" class="changecolor blue-text" tabindex="-1" href="#"
                                                   title="Blue color">
                            <local:message code="nav.label.blue"/></a>
                        </li>
                        <li role="presentation"><a role="menuitem" class="changecolor red-text" tabindex="-1" href="#"
                                                   title="Red color">
                            <local:message code="nav.label.red"/></a>
                        </li>
                        <li role="presentation"><a role="menuitem" class="changecolor orange-text" tabindex="-1"
                                                   href="#" title="Orange color">
                            <local:message code="nav.label.orange"/></a>
                        </li>
                        <li role="presentation"><a role="menuitem" class="changecolor navy-text" tabindex="-1" href="#"
                                                   title="Navy color">
                            <local:message code="nav.label.grey"/></a>
                        </li>
                        <li role="presentation"><a role="menuitem" class="changecolor dark-green-text" tabindex="-1"
                                                   href="#" title="Darkgreen color">
                            <local:message code="nav.label.darkGreen"/></a>
                        </li>
                    </ul>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="/basket"> <local:message code="nav.label.basket"/></a></li>
                    <li><a href="/j_spring_security_logout"> <local:message code="nav.label.exit"/></a></li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="/login"> <local:message code="nav.label.enter"/></a></li>
                    <li><a href="/registration"> <local:message code="nav.label.registration"/></a></li>
                </c:if>
                <li><a href="?lang=ru">ru</a></li>
                <li><a href="?lang=en">en</a></li>
            </ul>
        </div>
    </div>
</nav>
