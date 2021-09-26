<%--
  Created by IntelliJ IDEA.
  User: Berkay
  Date: 21-Sep-21
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.apparel.actions.controler.CartPageController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:page pageTitle="${title}">

    <div>

        <table align="center" width="70%" style="margin-top: 40px">
            <tr>
                <th>Product name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Remove from Cart</th>
            </tr>
            <c:forEach var="items" items="${cartItems}">
                <tr style="margin-top: 30px ">
                    <td><a href="/p/${items.key.id}">${items.getKey().name}</a></td>
                    <td>${items.getKey().price}</td>
                    <td>${items.getValue()}</td>

                    <td><a href="/cart/delete?id=${items.key.code}">
                        <button>Delete</button>
                    </a></td>

                </tr>

            </c:forEach>
        </table>


        <div align="right" style="margin: 40px; display: flex;flex-direction: column;font-weight: bold">
            <label style="flex-grow: 1">Cart : <span style="text-decoration: line-through;">${totalAmount.total}</span>
            </label>
            <label style="flex-grow: 1"> <span style="color: darkviolet"><c:if
                    test="${(totalAmount.total*0.2)>=totalAmount.discount && totalAmount.discount!=0}">You earned 20% discount for over 200 TL shopping!</c:if>
                <c:if test="${totalAmount.total*0.2<totalAmount.discount && totalAmount.discount!=0}">You earned 1 free dress over 3 and more dress purchases!</c:if></span>
                Discount : <span style="color: crimson">${totalAmount.discount}</span></label>
            <label style="flex-grow: 1">Tax : ${totalAmount.taxAmount} </label>
            <label style="flex-grow: 1">Total: ${totalAmount.discountedAmount} </label>
        </div>

        <div align="center" style="margin-bottom: 100px">
            <a href="<c:url value='/orders/create' />">
                <button>Checkout Now !</button>
            </a>

        </div>


    </div>


</template:page>