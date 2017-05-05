<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="url_images" value="/images" htmlEscape="true"/>
<a href="<spring:url value="/" htmlEscape="true"/>">Home</a>
<br/>
<br/>
<h1><spring:message code="page.security.accessDenied.sorryMsg" text=""/></h1>
<img src="${url_images}/forbidden.gif" alt="forbidden"/>