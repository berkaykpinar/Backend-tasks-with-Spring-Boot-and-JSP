<%--
  Created by IntelliJ IDEA.
  User: Berkay
  Date: 26-Sep-21
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="com.apparel.actions.controler.CartPageController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<template:page pageTitle="${title}">
<div>
    <div>

        <table align="center" width="70%"  style="margin-top: 40px" >
            <tr >
                <th>Order Number</th>
                <th>Price</th>
            </tr>
            <c:forEach var="order" items="${getOrders}">
                <tr style="margin-top: 30px ">
<%--                    <td><a href="/p/${items.key.categories}">${items.getKey().name}</a> </td>--%>
                    <td>${order.id}</td>
                    <td>${order.total}</td>
                    <td><a href="/orders/detail/${order.id}"><button>Go to Order details</button></a></td>
                </tr>

            </c:forEach>
        </table>



    </div>
</div>

</template:page>