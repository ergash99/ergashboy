<%--
  Created by IntelliJ IDEA.
  User: gayratjon
  Date: 4/25/14
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url var="url_ctx" value="/" htmlEscape="true" scope="session"/>
<spring:url var="url_css" value="/static/css" htmlEscape="true" scope="session"/>
<spring:url var="url_images" value="/static/images" htmlEscape="true" scope="session"/>
<spring:url var="url_js" value="/static/js" htmlEscape="true" scope="session"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Test</title>
    <link rel="stylesheet" href="${url_css}/bootstrap.min.css">
    <link rel="stylesheet" href="${url_css}/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="${url_css}/login/login.css">


    <%--<script src="${url_js}/admin/admin.js" type="text/javascript"></script>--%>
    <script src="${url_js}/bootstrap.min.js"></script>
    <script src="${url_js}/jquery.min.js"></script>
    <script src="${url_js}/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>

<body class="login">

<tiles:insertAttribute name="content"/>


</body>

</html>

