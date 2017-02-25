<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
    <div class="widget">
        <h1><local:message code="catalog.label.sort"/> ParticleBoard:</h1>
        <form action="/searchParticleBoards" method="GET">
            <div class="body bordered">
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
                    <h2><local:message code="catalog.sort.label.color"/>:</h2>
                    <hr>
                    <div class="le-select">
                        <select name="color">
                            <option disabled><local:message code="catalog.sort.label.color"/></option>
                                    <option selected value="">Not important</option>
                                    <option selected value="white">white</option>
                                    <option selected value="black">black</option>
                                    <option selected value="orange">orange</option>
                        </select>
                    </div>
                </div>
                <hr>
                <input type="submit" value="<local:message code="catalog.label.search"/>"/>
            </div>
        </form>
    </div>
</div>