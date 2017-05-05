<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<spring:url var="url_login_action" value="/j_security_login" htmlEscape="true"/>
<div class="wrapper">
    <form class="form-signin" action="${url_login_action}" method="post">
        <h2 class="form-signin-heading"><spring:message code="login.title"/> </h2>
        <input type="text" name="j_username" class="form-control" name="username" placeholder="<spring:message code="login.username"/>" required="" autofocus="" />
        <input type="password" name="j_password" class="form-control" name="password" placeholder="<spring:message code="login.password"/>" required=""/>
        <c:if test="${loginAttempt>=1}">
            <div class="input-prepend" style="display: block">
                <span class="add-dark-captcha"><img src="/captcha/captcha.jpg" class="img_captcha"></span>
                <input type="text" placeholder="captcha" class="captcha" name="j_captcha">
            </div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login.btSubmit"/></button>
    </form>
</div>