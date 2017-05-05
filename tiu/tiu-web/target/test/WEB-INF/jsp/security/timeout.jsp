<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/>
<br/>
<div style="text-align: center; width: 100%">
<a href="<spring:url value="/" htmlEscape="true"/>">Home</a>
<br/>
<br/>
<img src="${url_images}/elp/timeout.jpg" alt="timeout">
<br/>
<br/>
<h1><spring:message code="page.security.timeout.sorryMsg" text=""/></h1>
<br/>
<br/>
</div>

