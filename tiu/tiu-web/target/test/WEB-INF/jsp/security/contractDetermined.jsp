<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div aria-hidden="true" aria-labelledby="myModalLabel1" role="dialog" tabindex="-1" class="modal hide fade"
     id="myModal1">
    <div class="modal-header modal-default">
        <h3 id="myModalLabel1"><spring:message code="security.notice"/></h3>
    </div>
    <div class="modal-body">
        <spring:message code="access.blocked"/>!!!
    </div>
    <div class="modal-footer">
        <security:authorize ifAnyGranted="ROLE_SYSADMIN">
            <a href="/admin/customers-list.htm" aria-hidden="true" data-dismiss="modal" class="btn btn-primary">
                <spring:message code="security.back"/>
            </a>
        </security:authorize>
        <a href="http://uzgps.uz/" aria-hidden="true" data-dismiss="modal" class="btn btn-primary">
            <spring:message code="security.home"/>
        </a>
    </div>
</div>
