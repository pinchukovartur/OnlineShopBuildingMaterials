<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="local" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
    <div class="widget">
        <h1><local:message code="catalog.label.sort"/> Robot:</h1>
        <form action="/searchRobots" method="GET">
            <div class="body bordered">
                <div class="productionYear-filter">
                    <label>
                        <h2><local:message code="catalog.sort.label.productionYear"/></h2>
                        <input type="range" name="productionYear" min="1995" max="2017" value="0" id="fader2"
                               step="1" oninput="outputUpdate2(value)">
                        <output for="fader2" id="volume2">0</output>
                    </label>
                </div>
                <div class="maxLoad-filter">
                    <label>
                        <h2><local:message code="catalog.sort.label.maxLoad"/></h2>
                        <input type="range" name="maxLoad" min="0" max="2000" value="0" id="fader"
                               step="1" oninput="outputUpdate(value)">
                        <output for="fader" id="volume">0</output>
                    </label>
                </div>
                <div class="reach-filter">
                    <label>
                        <h2><local:message code="catalog.sort.label.reach"/></h2>
                        <input type="range" name="reach" min="0" max="2000" value="0" id="fader3"
                               step="1" oninput="outputUpdate3(value)">
                        <output for="fader3" id="volume3">0</output>
                    </label>
                </div>
                <div class="manufacturer-filter">
                    <h2><local:message code="catalog.sort.label.manufacturer"/>:</h2>
                    <hr>
                    <div class="le-select">
                        <select name="manufacturer">
                            <option disabled><local:message code="catalog.sort.label.manufacturer"/></option>
                            <c:choose>
                                <c:when test="${manufacturer==0}">
                                    <option selected value="0">Not important</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="0">Not important</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${manufacturer==0}">
                                    <option selected value="Kuka">Kuka</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Kuka">Kuka</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${manufacturer==0}">
                                    <option selected value="ABB">ABB</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="ABB">ABB</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <div class="price-filter">
                    <h2><local:message code="catalog.label.price"/></h2>
                    <hr>
                    <label>
                        <local:message code="catalog.label.with"/>:
                    </label><br>
                    <input name='priceWith'/><br>
                    <label>
                        <local:message code="catalog.label.before"/>:
                    </label><br>
                    <input name='priceBefore' type=""/>
                </div>

                <hr>
                <input type="submit" value="<local:message code="catalog.label.search"/>"/>
            </div>
        </form>
    </div>

    <script>
        function outputUpdate(vol) {
            document.querySelector('#volume').value = vol;
        }
        function outputUpdate2(vol2) {
            document.querySelector('#volume2').value = vol2;
        }
        function outputUpdate3(vol3) {
            document.querySelector('#volume3').value = vol3;
        }
    </script>

</div>

