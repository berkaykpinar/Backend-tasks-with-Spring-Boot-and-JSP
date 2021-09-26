<%--
  Created by IntelliJ IDEA.
  User: Berkay
  Date: 26-Sep-21
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.apparel.actions.controler.CartPageController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:page pageTitle="${title}">
    <div style="margin: 50px">


        <table align="center" width="70%" style="margin-top: 40px">
            <tr>
                <th>Order Number</th>
                <th>Total Amount</th>
                <th>Discount</th>
                <th>Tax</th>
                <th>Paid</th>
            </tr>
            <tr>
                <td>${orderModel.id}</td>
                <td>${orderModel.total}</td>
                <td>${orderModel.discount}</td>
                <td>${orderModel.taxAmount}</td>
                <td>${orderModel.discountedAmount}</td>
            </tr>

        </table>

    </div>

</template:page>