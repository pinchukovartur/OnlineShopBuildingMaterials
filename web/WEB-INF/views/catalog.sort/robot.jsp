<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
    <div class="widget">
        <h1><local:message code="catalog.label.sort"/> Robot:</h1>
        <form action="/page" method="GET">
            <div class="body bordered">
                <div class="category-filter">
                    <label>
                        <local:message code="catalog.sort.label.productionYear"/>
                        <input name="productionYear">
                    </label>
                </div>

                <div class="price-filter">
                    <h2><local:message code="catalog.sort.label.manufacturer"/>:</h2>
                    <hr>
                    <div class="le-select">
                        <select name="manufacturer">
                            <option disabled><local:message code="catalog.label.grade"/></option>
                            <c:choose>
                                <c:when test="${grade==0}">
                                    <option selected value="0">Not important</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="0">Not important</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${grade==0}">
                                    <option selected value="Kuka">Kuka</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Kuka">Kuka</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${grade==0}">
                                    <option selected value="ABB">ABB</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="ABB">ABB</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>

                    <div class="category-filter">
                        <label>
                            <local:message code="catalog.sort.label.maxLoad"/>
                            <input type="range" min="1" max="5" value="3" name="maxLoad">
                        </label>
                    </div>
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


                <hr>
                <input type="submit" name="register" value="<local:message code="catalog.label.search"/>"/>
            </div>
        </form>
    </div>
</div>