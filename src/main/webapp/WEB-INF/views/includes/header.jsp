<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<header>
    <div class="container no-padding">
        <div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
            <div class="logo">
                <a href="/">
                    <img alt="vmc_and_hmc" src="<c:url value="/static/jpg/eftech.png"/>" width="200" height="70"/>
                </a>
            </div>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 top-search-holder no-margin">
            <div class="contact-row">
                <div class="phone inline">
                    <i class="fa fa-phone"></i> <span class="le-color">+375 29 123-45-67</span>
                </div>
                <div class="contact inline">
                    <i class="fa fa-envelope"></i> <span class="le-color">TEST@gmail.com</span>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-12 col-md-3 top-cart-row no-margin">
            <div class="top-cart-row-container">
                <div class="top-cart-holder dropdown animate-dropdown">
                    <div class="basket">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="/basket">
                            <div class="basket-item-count">
                                <span class="count">${productsInBasket}</span>
                                <img src="<c:url value="/static/assets/images/icon-cart.png"/>" alt=""/>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>