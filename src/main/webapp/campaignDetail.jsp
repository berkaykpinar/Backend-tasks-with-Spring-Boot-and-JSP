<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 9/19/21
  Time: 3:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/kampanyalar/addFeedback" var="formposturl"/>

<template:page pageTitle="${title}">


    <!-- Header section end -->

    <!-- Page info -->
    <div class="page-top-info">
        <div class="container">
            <div class="site-pagination">
                <a href="">Home</a> /
                <a href="">Category</a>
            </div>
        </div>
    </div>
    <!-- Page info end -->

    <div class="container">
        <h1>${pageName}</h1>
    </div>

    <!-- Category section -->
    <input type="hidden" id="categoryCode" value="${categoryCode}"/>
    <section class="category-section spad" id="categoryPageApp">
        <div class="container">
            <div class="row">

                    ${feedbackmessage}

                <div class="col-lg-12  order-1 order-lg-2 mb-5 mb-lg-0">
                    <div class="row">
                        <c:forEach var="product" items="${productList}">
                            <div class="col-lg-4 col-sm-6" v-for="(product, productIndex) in categoryPageData.products">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <c:choose>
                                            <c:when test="${categoryCode eq 1}">
                                                <div class="tag-sale">4 Al 3 Öde</div>
                                            </c:when>
                                            <c:when test="${categoryCode eq 2}">
                                                <div class="tag-sale">%45 İndirim</div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="tag-sale">20 TL Hediye</div>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:if test="${categoryCode ne 2}">
                                            <div class="tag-sale" style="right:90px">Ek İndirim</div>
                                        </c:if>

                                        <c:if test="${categoryCode gt 2}">
                                            <div class="tag-sale" style="left:16px">Son 3 gün</div>
                                        </c:if>

                                        <a href="/apparel/p/${product.code}">
                                            <img src="/apparel/img/product/${product.image}.jpg" alt=""/>
                                        </a>
                                        <div class="pi-links">
                                            <a href="#" class="add-card"><i
                                                    class="flaticon-bag"></i><span>ADD TO CART</span></a>
                                            <a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                                        </div>
                                    </div>
                                    <div class="pi-text">
                                        <h6>${product.price} TL</h6>
                                        <p>${product.name}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <h3>Send Feedback</h3>
                        <div class="col-lg-12  order-1 order-lg-2 mb-5 mb-lg-0">
                            <div class="row">
                                <form action="${formposturl}" method="POST">
                                    <div class="col-12">
                                        <input id="name" name="name" type="text" placeholder="Your name">
                                    </div>
                                    <div class="col-12">
                                        <input id="surname" name="surname" type="text" placeholder="Your Surname">
                                    </div>
                                    <div class="col-12">
                                        <textarea id="message" name="message" rows="8" placeholder="Message"></textarea>
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="site-btn">SEND NOW</button> &nbsp;&nbsp;
                                        <button type="button" id="sendAjaxBtn" class="site-btn">SEND NOW AJAX</button>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </section>

</template:page>
