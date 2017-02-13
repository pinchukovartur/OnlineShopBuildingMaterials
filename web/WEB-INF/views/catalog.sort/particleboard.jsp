<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
    <div class="widget">
        <h1><local:message code="catalog.label.sort"/> ParticleBoard:</h1>
        <form action="/page" method="GET">
            <div class="body bordered">
                <div class="category-filter">
                    <h2><local:message code="label.type"/></h2>
                    <hr>
                    <ul>
                        <c:choose>
                            <c:when test="${particleBoard==1}">
                                <li><input checked="checked" class="le-checkbox" type="checkbox"
                                           name='checkbox_particleBoard' value='1'/>
                                    <label>
                                        <local:message code="index.label.particleBoard"/>
                                    </label>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><input class="le-checkbox" type="checkbox" name='checkbox_particleBoard'
                                           value='1'/>
                                    <label>
                                        <local:message code="index.label.particleBoard"/>
                                    </label>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${plywood==1}">
                                <li><input checked="checked" class="le-checkbox" type="checkbox"
                                           name='checkbox_plywood' value='1'/>
                                    <label>
                                        <local:message code="index.label.plywood"/>
                                    </label>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><input class="le-checkbox" type="checkbox" name='checkbox_plywood'
                                           value='1'/>
                                    <label>
                                        <local:message code="index.label.plywood"/>
                                    </label>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>

                <div class="price-filter">
                    <h2><local:message code="catalog.label.price"/></h2>
                    <hr>
                    <label>
                        <local:message code="catalog.label.with"/>:
                    </label><br>
                    <input name='input_with'/><br>
                    <label>
                        <local:message code="catalog.label.before"/>:
                    </label><br>
                    <input name='input_before' type=""/>
                </div>

                <div class="price-filter">
                    <h2><local:message code="catalog.label.grade"/>:</h2>
                    <hr>
                    <div class="le-select">
                        <select name="grade">
                            <option disabled><local:message code="catalog.label.grade"/></option>
                            <c:choose>
                                <c:when test="${grade==0}">
                                    <option selected value="0">Not important</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="0">Not important</option>
                                </c:otherwise>
                            </c:choose>
                            <c:forEach var="i" begin="1" end="5">
                                <c:choose>
                                    <c:when test="${grade==i}">
                                        <option selected value=${i}>
                                                ${i}
                                            <local:message code="catalog.label.grade"/>
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value=${i}>
                                                ${i}
                                            <local:message code="catalog.label.grade"/>
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <hr>
                <input type="submit" name="register" value="<local:message code="catalog.label.search"/>"/>
            </div>
        </form>
    </div>
</div>