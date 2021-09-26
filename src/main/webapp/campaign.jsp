<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 9/19/21
  Time: 3:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

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

    <div class="col-lg-12">
            <c:if test="${not empty feedbackMessage}">
                ${feedbackMessage} mesajınız alınmıştır, teşekkür ederiz.
            </c:if>
    </div>


    <div class="container">
        <h1>${pageName}</h1>
    </div>

    <!-- Category section -->
    <input type="hidden" id="categoryCode" value="${categoryCode}"/>
    <section class="category-section spad" id="categoryPageApp">
        <div class="container">
            <div class="row">

                <div class="col-lg-12  order-1 order-lg-2 mb-5 mb-lg-0">
                    <div class="row">
                            <div class="col-lg-4 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <div class="tag-sale">ON SALE</div>
                                        <a href="/apparel/kampanyalar/1">
                                            <img src="/apparel/img/product/4.jpg" alt=""/>
                                        </a>
                                        <div class="pi-links">
                                            <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                                            <a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                                        </div>
                                    </div>
                                    <div class="pi-text">
                                        <p>4 al 3 öde kampanyası</p>
                                    </div>
                                </div>
                            </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="product-item">
                                <div class="pi-pic">
                                    <div class="tag-sale">ON SALE</div>
                                    <a href="/apparel/kampanyalar/2">
                                        <img src="/apparel/img/product/4.jpg" alt=""/>
                                    </a>
                                    <div class="pi-links">
                                        <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                                        <a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                                    </div>
                                </div>
                                <div class="pi-text">
                                    <p>Seçili tüm ürünlerde %45 indirim</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="product-item">
                                <div class="pi-pic">
                                    <div class="tag-sale">ON SALE</div>
                                    <a href="/apparel/kampanyalar/3">
                                        <img src="/apparel/img/product/4.jpg" alt=""/>
                                    </a>
                                    <div class="pi-links">
                                        <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                                        <a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                                    </div>
                                </div>
                                <div class="pi-text">
                                    <p>Anında 20 TL hediyeli ürünler</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>

</template:page>