<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
    <div class="widget">
        <h1><local:message code="catalog.label.sort"/> Plywood:</h1>
        <form action="/searchPlywoods" method="GET">
            <div class="body bordered">
                <div class="category-filter">
                    <h2><local:message code="label.type"/></h2>
                    <hr>
                    <ul>
                        <li><input class="le-checkbox" type="checkbox"
                                   name='waterResistance' value='1'/>
                            <label>
                                <local:message code="catalog.sort.label.waterResistance"/>
                            </label>
                        </li>
                        <li><input class="le-checkbox" type="checkbox"
                                   name='sanded' value='1'/>
                            <label>
                                <local:message code="catalog.sort.label.sanded"/>
                            </label>
                        </li>
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
                            <c:forEach var="i" begin="1" end="5">
                                <option selected value=${i}>
                                        ${i}
                                    <local:message code="catalog.label.grade"/>
                                </option>
                            </c:forEach>
                            <option selected value="-1">Not important</option>
                        </select>
                    </div>
                </div>
                <hr>
                <input type="submit" name="register" value="<local:message code="catalog.label.search"/>"/>
            </div>
        </form>
    </div>
</div>